package ru.flamexander.multithreading.ex01_basics.ex01_threads_creation;

import ru.flamexander.multithreading.utils.Utils;

public class UsingRunnableInterface implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            Utils.sleepMs(500);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new UsingRunnableInterface());
        t.start();
    }
}