package ru.flamexander.multithreading.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static class ClientHandler {
        private Server server;
        private Socket socket;
        private DataInputStream in;

        public ClientHandler(Server server, Socket socket) throws IOException {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.equals("/shutdown")) {
                            server.shutdown();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        public void disconnect() {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ServerSocket serverSocket;
    private List<ClientHandler> clients;
    private boolean isActive;

    public Server() {
        this.clients = new ArrayList<>();
        this.isActive = true;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(8189);
            while (isActive) {
                Socket socket = serverSocket.accept();
                clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void shutdown() {
        System.out.println("Сервер выключаем");
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).disconnect();
        }
        isActive = false;
        try (Socket socket = new Socket("localhost", 8189)) {
        } catch (IOException e) {}
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().run();
    }
}
