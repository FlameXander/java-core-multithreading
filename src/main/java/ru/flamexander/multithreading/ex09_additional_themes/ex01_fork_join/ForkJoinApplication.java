package ru.flamexander.multithreading.ex09_additional_themes.ex01_fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkJoinApplication {
    public static void main(String[] args) {
        // ForkJoinPool commonPool = ForkJoinPool.commonPool();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -10 - (int)(Math.random() * 100000);
        }
        FJTask maxNegativeFinder = new FJTask(arr);
        System.out.println(maxNegativeFinder.compute());
    }
}
