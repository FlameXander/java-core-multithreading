package ru.flamexander.multithreading.ex09_additional_themes;

public class ThreadLocalExample {
    public static class MagicBox {
        ThreadLocal<Integer> value;

        public MagicBox() {
            this.value = new ThreadLocal<>();
        }

        public Integer getValue() {
            return value.get();
        }

        public void setValue(Integer value) {
            this.value.set(value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MagicBox box = new MagicBox();
        new Thread(() -> {
            box.setValue(10);
            System.out.println(box.getValue());
        }).start();
        box.setValue(50);
        Thread.sleep(1500);
        new Thread(() -> {
            System.out.println(box.getValue());
        }).start();

    }
}
