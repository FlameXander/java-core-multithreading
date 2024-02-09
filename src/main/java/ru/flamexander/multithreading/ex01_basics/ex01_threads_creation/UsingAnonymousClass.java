package ru.flamexander.multithreading.ex01_basics.ex01_threads_creation;

import static ru.flamexander.multithreading.utils.Utils.sleepSec;

public class UsingAnonymousClass { // or lambda
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                sleepSec(1);
            }
        });
        t.start();

        // public class UsingAnonymousClass$1 implements Runnable {
        // @Override
        //   public void run() {
        //     for (int i = 0; i < 10; i++) {
        //       System.out.println(i);
        //       sleepSec(1);
        //     }
        //   }
        // }
        // UsingAnonymousClass$1 r = new UsingAnonymousClass$1();
        // Thread t = new Thread(r);
    }
}
