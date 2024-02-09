package ru.flamexander.multithreading.ex01_basics.ex01_threads_creation;

import static ru.flamexander.multithreading.utils.Utils.*;

public class UsingThreadExtends extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMark(i);
            sleepMs(500);
        }
    }

    public static void main(String[] args) {
        Thread t = new UsingThreadExtends();
        t.start();
        for (int i = 0; i < 10; i++) {
            printMark(i);
            sleepMs(500);
        }
    }
}
