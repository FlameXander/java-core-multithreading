package ru.flamexander.multithreading.ex09_additional_themes.ex01_fork_join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FJTask extends RecursiveTask<Integer> {
    private int[] arr;
    private int left;
    private int right;

    private static final int THRESHOLD = 200;

    public FJTask(int[] arr) {
        this.arr = arr;
        this.left = 0;
        this.right = arr.length;
    }

    public FJTask(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    @Override
    protected Integer compute() {
        if (right - left > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .max()
                    .orElse(Integer.MIN_VALUE);
        } else {
            return processing(arr);
        }
    }

    private Collection<FJTask> createSubtasks() {
        List<FJTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new FJTask(arr, left, (left + right) / 2));
        dividedTasks.add(new FJTask(arr, (left + right) / 2, right));
        System.out.println(right - left);
        return dividedTasks;
    }

    private Integer processing(int[] arr) {
        System.out.println(Thread.currentThread().getName() + " EXECUTE");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.stream(arr)
                .skip(left)
                .limit(right - left)
                .filter(a -> a < 0)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
