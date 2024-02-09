package ru.flamexander.multithreading.ex03_synchronization.ex01_sync_methods;

public class SyncCounterApp {
    public static void main(String[] args) throws InterruptedException {
        SyncCounter syncCounter = new SyncCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                syncCounter.inc();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                syncCounter.dec();
            }
        });

        incThread.start();
        decThread.start();
        incThread.join();
        decThread.join();

        System.out.println("Значение синхр. счетчика: " + syncCounter.value());
    }
}
