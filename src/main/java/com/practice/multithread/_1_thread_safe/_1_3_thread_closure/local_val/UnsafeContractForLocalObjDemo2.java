package com.practice.multithread._1_thread_safe._1_3_thread_closure.local_val;

import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.UnsafeDemo;
import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.domain.UnsafeSequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 与 {@link UnsafeDemo}对比
 */
public class UnsafeContractForLocalObjDemo2 {
    private static UnsafeSequence unsafeSequence;


    public static void main(String[] args) {
        Runnable runnable = () -> {
            unsafeSequence = new UnsafeSequence();
            try {
                for (int i = 0; i < 10; i++) {
                    unsafeSequence.incr();

                    Thread.sleep(10);

                    unsafeSequence.decr();

                    Thread.sleep(10);

                    System.out.println("val = " + unsafeSequence.getValue());

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
