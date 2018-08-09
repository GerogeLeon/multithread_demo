package com.practice.multithread._1_thread_safe._1_3_thread_closure.thread_local;

/**
 * 对比： {@link UnsafeContrastForThreadLocal }， {@link UnsafeContrastForThreadLocal2}
 *
 * @author Luo Bao Ding
 */
public class ThreadLocalDemo {
    private ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    public void demo() {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    integerThreadLocal.set(1);

                    Thread.sleep(10);

                    integerThreadLocal.set(0);

                    Thread.sleep(10);

                    System.out.println("val=" + integerThreadLocal.get());

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
        new ThreadLocalDemo().demo();

    }
}
