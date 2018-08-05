package com.practice.multithread._2_objets_sharing._2_2_thread_closure.thread_local;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Luo Bao Ding
 */
public class UnsafeContrastForThreadLocal2 {
    private AtomicInteger val=new AtomicInteger(0);

    public void demo() {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    val.incrementAndGet();

                    Thread.sleep(10);

                    val.decrementAndGet();
                    Thread.sleep(10);


                    System.out.println("val=" + val.get());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        new UnsafeContrastForThreadLocal2().demo();

    }
}
