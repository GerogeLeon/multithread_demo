package com.practice.multithread._4_infrastructure._4_2_concurrent_container.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 场景：某花园参观需要许可证，总共10个许可证，共50人来参观
 *
 * @author Luo Bao Ding
 */
public class SemaphoreDemo {

    public void demo() {
        Semaphore semaphore = new Semaphore(10);

        Runnable visit = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + "\t尝试获取许可证......可用："+ semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(threadName + "\t获得了许可证，开始参观花园>>>>>>>>"+"剩余:" + semaphore.availablePermits());
                System.out.println(threadName + "\t参观花园中。。。。。。。。。");
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(threadName + "\t参观花园结束，退还许可证<<<<<<<<<");
                semaphore.release();
            }

        };

        for (int i = 0; i < 50; i++) {
            new Thread(visit, "user" + i).start();
        }
    }

    public static void main(String[] args) {
        new SemaphoreDemo().demo();
    }
}
