package ru.flamexander.multithreading.ex03_synchronization.ex06_reentrancy;

import static ru.flamexander.multithreading.utils.Utils.*;

public class ReentrancyApp {
    public static void main(String[] args) {
        ReentrancyApp app = new ReentrancyApp();
        for (int i = 0; i < 10; i++) {
            new Thread(app::multipleSync).start();
        }
    }

    public void multipleSync() {
        printMark(0);
        synchronized (this) {
            printMark(1);
            sleepSec(1);
            printMark(2);
            synchronized (this) {
                printMark(3);
                sleepSec(1);
                printMark(4);
            }
            printMark(5);
        }
        printMark(6);
    }
}
