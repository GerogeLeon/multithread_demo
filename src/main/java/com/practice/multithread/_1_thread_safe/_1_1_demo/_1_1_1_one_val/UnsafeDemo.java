package com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val;


import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.domain.UnsafeSequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class UnsafeDemo {

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();

        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    unsafeSequence.incr();

                    Thread.sleep(1);

                    unsafeSequence.decr();

                    System.out.println(Thread.currentThread().getName() + ": val = " + unsafeSequence.getValue());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(runnable);
        }

        threadPool.shutdown();


    }
}
