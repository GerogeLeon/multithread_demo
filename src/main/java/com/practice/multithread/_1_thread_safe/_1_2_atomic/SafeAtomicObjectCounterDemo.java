package com.practice.multithread._1_thread_safe._1_2_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 */
public class SafeAtomicObjectCounterDemo {

    private AtomicInteger count = new AtomicInteger(0);

    public void demo() {
        Runnable runnable = () -> {
            count.incrementAndGet();
            System.out.println("count = " + count.get());
        };
        for (int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }

    }

    public static void main(String[] args) {
        new SafeAtomicObjectCounterDemo().demo();
    }

}
