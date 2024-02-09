package ru.flamexander.multithreading.ex01_basics.ex02_common_questions;

public class ThreadStopping {
    public static void main(String[] args) {
        correct();
    }

    public static void wrong() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("tick");
            }
        });
        t.start();

        try {
            Thread.sleep(3000);
            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void correct() {
        Thread t = new Thread(() -> {
            boolean inter = false;
            while (true) {
                if (Thread.currentThread().isInterrupted() || inter) {
                    break;
                }
                System.out.println("tick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    inter = true;
                }
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}