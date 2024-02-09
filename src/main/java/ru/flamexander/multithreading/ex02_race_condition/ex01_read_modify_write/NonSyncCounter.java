package ru.flamexander.multithreading.ex02_race_condition.ex01_read_modify_write;

public class NonSyncCounter {
    private int c;

    public int value() { return c; }

    public void inc() {
        c++;
    }

    public void dec() {
        c--;
    }
}
