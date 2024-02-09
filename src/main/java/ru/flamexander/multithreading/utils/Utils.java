package ru.flamexander.multithreading.utils;

public class Utils {
    public static void sleepMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSec(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printMark(int mark) {
        System.out.printf("%s - %d\n", Thread.currentThread().getName(), mark);
    }
}
