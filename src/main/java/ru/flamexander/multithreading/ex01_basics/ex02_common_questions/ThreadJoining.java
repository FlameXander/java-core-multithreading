package ru.flamexander.multithreading.ex01_basics.ex02_common_questions;

public class ThreadJoining {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        thread.start();
        thread.join();
        System.out.println("END");
    }
}
