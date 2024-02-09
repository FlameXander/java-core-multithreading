package ru.flamexander.multithreading.ex05_executor_services;

import ru.flamexander.multithreading.utils.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskCancellation {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.execute(() -> {
            Utils.sleepSec(1);
        });
        Future f = service.submit(() -> {
            System.out.println(1);
            Utils.sleepSec(5);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("INTERRUPTED");
            }
            System.out.println(2);
        });
        Utils.sleepSec(3);
        f.cancel(true);
        service.shutdown();
    }
}
