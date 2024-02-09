package ru.flamexander.multithreading.ex05_executor_services.ex01_problem;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerRequest {
    /**
     * <B>Недостатки:</B>
     * <p>Thread lifecycle overhead
     * <p>Resource consumption
     * <p>Stability
     */
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(80)) {
            while (true) {
                try (final Socket connection = socket.accept()) {
                    Runnable task = new Runnable() {
                        public void run() {
                            // handleRequest(connection);
                        }
                    };
                    new Thread(task).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

