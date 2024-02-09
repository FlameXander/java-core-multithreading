package ru.flamexander.multithreading.ex06_wait_notify;

public class PrintABApp {
    public static void main(String[] args) {
        PrintABApp waitNotifyApp = new PrintABApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
    }

    public void printA() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("A");
        }
    }

    public void printB() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("B");
        }
    }
}

