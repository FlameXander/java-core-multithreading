package ru.flamexander.multithreading.ex02_race_condition.ex02_check_then_act;

import java.util.UUID;

public class LazyInitializationApp {
    private class LongInitClass {
        private UUID uuid;

        public LongInitClass() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.uuid = UUID.randomUUID();
        }
    }

    private LongInitClass instance = null;

    public LongInitClass getInstance() {
        if (instance == null) {
            instance = new LongInitClass();
        }
        return instance;
    }
}
