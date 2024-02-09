package ru.flamexander.multithreading.ex03_synchronization.ex03_sync_static_methods;

public class SyncStaticMethodApp {
    public static void main(String[] args) {
        SyncStaticMethodApp e = new SyncStaticMethodApp();
        new Thread(() -> classMethod()).start();
        new Thread(() -> e.objectMethod()).start();
    }

    public synchronized static void classMethod() {
        System.out.println("Synch Static Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Static Method End");
    }

    public synchronized static void classMethod2() {
        System.out.println("Synch Static Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Static Method End");
    }

    public synchronized void objectMethod() {
        System.out.println("Synch Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Method End");
    }
}
