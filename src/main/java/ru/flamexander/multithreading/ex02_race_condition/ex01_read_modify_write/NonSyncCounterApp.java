package ru.flamexander.multithreading.ex02_race_condition.ex01_read_modify_write;

public class NonSyncCounterApp {
    public static void main(String[] args) throws InterruptedException {
        NonSyncCounter nonSyncCounter = new NonSyncCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                nonSyncCounter.inc();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                nonSyncCounter.dec();
            }
        });

        incThread.start();
        decThread.start();
        incThread.join();
        decThread.join();

        System.out.println("Значение счетчика: " + nonSyncCounter.value());
    }
}
