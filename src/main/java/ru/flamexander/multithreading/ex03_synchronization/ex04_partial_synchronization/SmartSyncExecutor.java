package ru.flamexander.multithreading.ex03_synchronization.ex04_partial_synchronization;

import static ru.flamexander.multithreading.utils.Utils.sleepMs;

public class SmartSyncExecutor {
    public static void main(String[] args) {
        SmartSyncExecutor executor = new SmartSyncExecutor();
        new Thread(executor::executeLongOperation).start();
        new Thread(executor::executeLongOperation).start();
        new Thread(executor::executeLongOperation).start();
    }

    public void wrongExecuteLongOperation() {
        for (int i = 0; i < 3; i++) {
            System.out.println('.');
            sleepMs(400);
        }
        // -- Только блок ниже нельзя выполнять параллельно
        for (int i = 0; i < 5; i++) {
            System.out.println(".non-parallel-only.");
            sleepMs(400);
        }
        // -- Завершили опасный блок
        for (int i = 0; i < 3; i++) {
            System.out.println('.');
            sleepMs(400);
        }
    }

    public void executeLongOperation() {
        System.out.println("NonSync-Begin " + Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println('.');
            sleepMs(400);
        }
        System.out.println("NonSync-End " + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("Sync-Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(".non-parallel-only.");
                sleepMs(400);
            }
            System.out.println("Sync-End " + Thread.currentThread().getName());
        }
        System.out.println("NonSync-Begin " + Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println('.');
            sleepMs(400);
        }
        System.out.println("NonSync-End " + Thread.currentThread().getName());
    }
}
