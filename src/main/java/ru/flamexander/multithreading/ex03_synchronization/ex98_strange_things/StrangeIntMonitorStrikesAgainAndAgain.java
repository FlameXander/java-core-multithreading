package ru.flamexander.multithreading.ex03_synchronization.ex98_strange_things;

public class StrangeIntMonitorStrikesAgainAndAgain {
    private static class TaskExecutor {
        private Integer mon = 1;

        public TaskExecutor() {
            new Thread(() -> {
                synchronized (mon) {
                    System.out.println("start");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end");
                }
            }).start();
        }
    }

    private static class AnotherTaskExecutor {
        private Integer mon = 1;

        public AnotherTaskExecutor() {
            new Thread(() -> {
                synchronized (mon) {
                    System.out.println("start");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end");
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new TaskExecutor();
        }
        for (int i = 0; i < 5; i++) {
            new AnotherTaskExecutor();
        }
    }
}
