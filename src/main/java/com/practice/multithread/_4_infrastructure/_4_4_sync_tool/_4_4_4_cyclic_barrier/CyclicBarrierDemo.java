package com.practice.multithread._4_infrastructure._4_4_sync_tool._4_4_4_cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 产品迭代：每次迭代前端、后端、移动端都完成了才能发布
 *
 * @author Luo Bao Ding
 */
public class CyclicBarrierDemo {

    public void demo() {
        AtomicInteger id = new AtomicInteger(1);
        final int TOTAL = 20;//一年20次迭代
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println(">>>>>>>>>>迭代ID" + id.getAndIncrement() + "发布"));
        Runnable frontEnd = () -> {
            for (int i = 0; i < TOTAL; i++) {
                System.out.println("前端开发完成：迭代ID" + id.get());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable backEnd = () -> {
            for (int i = 0; i < TOTAL; i++) {
                System.out.println("后端开发完成：迭代ID" + id.get());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable mobileEnd = () -> {
            for (int i = 0; i < TOTAL; i++) {
                System.out.println("移动端开发完成：迭代ID" + id.get());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(frontEnd).start();
        new Thread(backEnd).start();
        new Thread(mobileEnd).start();


    }

    public static void main(String[] args) {
        new CyclicBarrierDemo().demo();
    }
}
