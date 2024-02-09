package ru.flamexander.multithreading.ex01_basics.ex03_advanced_questions;

public class ThreadLocalData {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> tls = new ThreadLocal<>();
        tls.set("1");
        System.out.println(Thread.currentThread().getName() + " - " + tls.get());

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + tls.get());
            tls.set("2");
            System.out.println(Thread.currentThread().getName() + " - " + tls.get());
        }).start();

        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " - " + tls.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + tls.get());
        }).start();
    }
}
