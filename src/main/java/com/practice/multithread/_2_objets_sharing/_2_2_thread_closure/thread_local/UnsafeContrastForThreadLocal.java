package com.practice.multithread._2_objets_sharing._2_2_thread_closure.thread_local;

/**
 * @author Luo Bao Ding
 */
public class UnsafeContrastForThreadLocal {
    private volatile int val;

    public void demo() {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    val = 1;

                    Thread.sleep(10);

                    val = 0;
                    Thread.sleep(10);


                    System.out.println("val=" + val);

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
        new UnsafeContrastForThreadLocal().demo();

    }
}
