package com.practice.multithread._1_thread_safe._1_5_question;

import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.domain.UnsafeSequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Luo Bao Ding
 */
public class RaceConditionDemo {

    /*
     * 下面是否线程安全？
     * */
    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        Runnable runnable = () -> {
            try {
                for (int j = 0; j < 10; j++) {
                    /*竞态条件:先检查后执行
                     * */
                    if (unsafeSequence.getValue() == 0) {
                        unsafeSequence.incr();
                    }

                    Thread.sleep(1);


                    if (unsafeSequence.getValue() == 1) {
                        unsafeSequence.decr();
                    }

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
