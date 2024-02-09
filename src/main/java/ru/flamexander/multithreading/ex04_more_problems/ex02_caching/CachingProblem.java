package ru.flamexander.multithreading.ex04_more_problems.ex02_caching;

import ru.flamexander.multithreading.utils.Utils;

import static ru.flamexander.multithreading.utils.Utils.*;

public class CachingProblem {
    private static int value = 0;

    public static void main(String[] args) {
        Object mon = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (mon) {
                value = 10;
                sleepMs(100);
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(value);
        });
        t1.start();
        Utils.sleepMs(500);
        t2.start();
    }
}
