package ru.flamexander.multithreading.ex10_examples.ex01_pseudo_cas;

public class CASCounter {
    private PseudoCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
