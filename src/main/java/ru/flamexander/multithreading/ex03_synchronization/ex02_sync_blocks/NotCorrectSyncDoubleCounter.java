package ru.flamexander.multithreading.ex03_synchronization.ex02_sync_blocks;

public class NotCorrectSyncDoubleCounter {
    private int c1;
    private int c2;

    public synchronized int value1() {
        return c1;
    }

    public synchronized int value2() {
        return c2;
    }

    public synchronized void inc1() {
        c1++;
    }

    public synchronized void inc2() {
        c2++;
    }

    public synchronized void dec1() {
        c1--;
    }

    public synchronized void dec2() {
        c2--;
    }
}
