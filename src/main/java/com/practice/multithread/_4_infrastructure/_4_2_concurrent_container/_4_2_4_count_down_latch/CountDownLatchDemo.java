package com.practice.multithread._4_infrastructure._4_2_concurrent_container._4_2_4_count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * 一家四口，来客人时匆忙打扫卫生，通过分工打扫，都打扫完了才开门
 */
public class CountDownLatchDemo
{
    public static void main(String args[]) 
                   throws InterruptedException
    {
        // Let us create task that is going to 
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);
 
        // Let us create four worker 
        // threads and start them.
        Worker first = new Worker(1000, latch, 
                                  "爸爸");
        Worker second = new Worker(2000, latch,
                                  "妈妈");
        Worker third = new Worker(3000, latch,
                                  "儿子");
        Worker fourth = new Worker(4000, latch,
                                  "女儿");
        first.start();
        second.start();
        third.start();
        fourth.start();
 
        // The main task waits for four threads
        latch.await();
 
        // Main thread has started
        System.out.println("开门让客人进来！");
    }
}
 
// A class to represent threads for which
// the main thread waits.
class Worker extends Thread
{
    private int delay;
    private CountDownLatch latch;
 
    public Worker(int delay, CountDownLatch latch,
                                    String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }
 
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                            + "打扫完了");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
