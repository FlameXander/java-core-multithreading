package ru.flamexander.multithreading.ex03_synchronization.ex98_strange_things;

public class StrangeIntMonitorStrikesAgain {
    private static Integer mon1 = 1;
    private static Integer mon2 = 1;
    private static Integer mon3 = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (mon1) {
                System.out.println("1-start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1-end");
            }
        }).start();
        new Thread(() -> {
            synchronized (mon2) {
                System.out.println("2-start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2-end");
            }
        }).start();
        new Thread(() -> {
            synchronized (mon3) {
                System.out.println("3-start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3-end");
            }
        }).start();
    }
}
