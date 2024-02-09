package ru.flamexander.multithreading.ex05_executor_services;

import ru.flamexander.multithreading.utils.Utils;

import java.util.concurrent.*;

public class Temp {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(4, 8,10,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(20),new ThreadPoolExecutor.DiscardOldestPolicy());


    }
}
