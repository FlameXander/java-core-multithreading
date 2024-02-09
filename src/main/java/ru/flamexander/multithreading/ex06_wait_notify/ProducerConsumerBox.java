package ru.flamexander.multithreading.ex06_wait_notify;

import ru.flamexander.multithreading.utils.Utils;

public class ProducerConsumerBox {
    private final Object monitor = new Object();
    private String item;

    public void put(String item) {
        synchronized (monitor) {
            this.item = item;
            System.out.println("Положили в коробку: " + item);
            monitor.notifyAll();
        }
    }

    public void throwAway() {
        synchronized (monitor) {
            while (item == null) {
                try {
                    System.out.println("Ну я пожалуй подожду");
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Вытащили из коробки: " + item);
            item = null;
            System.out.println("На этом моя миссия завершена");
        }
    }

    public static void main(String[] args) {
        ProducerConsumerBox box = new ProducerConsumerBox();
        Thread threadConsumer = new Thread(() -> {
            box.throwAway();
        });
//        Thread threadProducer = new Thread(() -> {
//            box.put("Ball");
//        });
        threadConsumer.start();
        Utils.sleepSec(8);
//        threadProducer.start();
        threadConsumer.interrupt();
    }
}
