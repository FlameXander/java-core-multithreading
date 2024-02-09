package ru.flamexander.multithreading.ex01_basics.ex03_advanced_questions;

import java.util.concurrent.*;

public class ExceptionsFromThread {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(() -> {
            System.out.println("Асинхронный вызов");
            int x = 10 / 0;
            return "Результат из потока";
        });
        try {
            System.out.println("future.get() = " + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
