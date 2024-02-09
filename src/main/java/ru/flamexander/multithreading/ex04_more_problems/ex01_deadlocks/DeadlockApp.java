package ru.flamexander.multithreading.ex04_more_problems.ex01_deadlocks;

import static ru.flamexander.multithreading.utils.Utils.sleepSec;

public class DeadlockApp {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne threadOne = new DeadThreadOne();
        DeadThreadTwo threadTwo = new DeadThreadTwo();
        threadOne.start();
        threadTwo.start();
    }

    private static class DeadThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadThreadOne is holding LOCK 1...");
                sleepSec(1);
                System.out.println("DeadThreadOne is waiting for Lock 2...");
                synchronized (lock2) {
                    System.out.println("DeadThreadOne is holding Lock 1 and Lock 2...");
                }
            }
        }
    }

    private static class DeadThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadThreadTwo is holding LOCK 2...");
                sleepSec(1);
                System.out.println("DeadThreadTwo is waiting for Lock 1...");
                synchronized (lock1) {
                    System.out.println("DeadThreadTwo is holding Lock 1 and Lock 2...");
                }
            }
        }
    }
}
