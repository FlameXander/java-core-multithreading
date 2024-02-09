package ru.flamexander.multithreading.ex03_synchronization.ex02_sync_blocks;

public class SyncDoubleCounter {
    private int c1 = 0;
    private int c2 = 0;

    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public void inc1() {
        synchronized (mon1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized (mon2) {
            c2++;
        }
    }

    public int value1() {
        synchronized (mon1) {
            return c1;
        }
    }

    public int value2() {
        synchronized (mon2) {
            return c2;
        }
    }

    public void dec1() {
        synchronized (mon1) {
            c1--;
        }
    }

    public void dec2() {
        synchronized (mon2) {
            c2--;
        }
    }
}
