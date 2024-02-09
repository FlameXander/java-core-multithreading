package ru.flamexander.multithreading.ex01_basics.ex02_common_questions;

public class ThreadStartingOrder {
    public static void main(String[] args) {
        for (int i = 1; i <= 24; i++) {
            final int in = i;
            new Thread(() -> System.out.println(in)).start();
        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(2);
//            }
//        }).start();
    }
}
