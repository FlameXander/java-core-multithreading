package ru.flamexander.multithreading.ex99_very_hard;

public class DoubleCheckedLocking {
    private static Integer resource;

    public static Integer getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null) {
                    resource = new Integer(10);
                }
            }
        }
        return resource;
    }
}
