package ru.flamexander.multithreading.ex02_race_condition.ex01_read_modify_write;

public class SynchCounter {
    private int c;

    public synchronized int value() { return c; }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec() {
        c--;
    }
}