package ru.flamexander.multithreading.ex03_synchronization.ex02_sync_blocks;

public class SyncCounterApp {
    public static void main(String[] args) {
        SyncDoubleCounter syncDoubleCounter = new SyncDoubleCounter();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                syncDoubleCounter.inc1();
                System.out.println("sdc.value1: " + syncDoubleCounter.value1());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                syncDoubleCounter.dec1();
                System.out.println("sdc.value1: " + syncDoubleCounter.value1());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                syncDoubleCounter.inc2();
                System.out.println("sdc.value2: " + syncDoubleCounter.value2());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                syncDoubleCounter.dec2();
                System.out.println("sdc.value2: " + syncDoubleCounter.value2());
            }
        }).start();
    }
}
