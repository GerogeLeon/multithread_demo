package com.practice.multithread._1_thread_safe._1_3_question;


import com.practice.multithread._1_thread_safe._1_3_question.domain.AtomicSequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Luo Bao Ding
 */
public class NarrowAtomicScopeDemo {

    public static void main(String[] args) {
        AtomicSequence unsafeSequence = new AtomicSequence();

        Runnable runnable = () -> {
            try {
                for (int j = 0; j < 10; j++) {
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
