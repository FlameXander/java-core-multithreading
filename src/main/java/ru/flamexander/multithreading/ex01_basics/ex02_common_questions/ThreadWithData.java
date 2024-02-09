package ru.flamexander.multithreading.ex01_basics.ex02_common_questions;

public class ThreadWithData {
    private static class FileTask implements Runnable {
        private String filename;

        public FileTask(String filename) {
            this.filename = filename;
        }

        @Override
        public void run() {
            System.out.println(filename);
        }
    }

    public static void main(String[] args) {
        new Thread(new FileTask("1.txt")).start();
    }
}
