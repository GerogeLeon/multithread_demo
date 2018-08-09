package com.practice.multithread._2_objets_sharing;

/**
 * 期望1000个子线程都能执行完，但是由于可见性问题而出现死循环
 */
public class VisibilityByVolatileDemo {
    private static volatile boolean ready = false;
    private static int number = 0;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                //...
            }
            System.out.println(Thread.currentThread().getName() + ": number = " + number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new ReaderThread().start();
        }
        Thread.sleep(1000);

        number = 100;
        ready = true;
    }
}
