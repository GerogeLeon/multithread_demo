package com.practice.multithread._4_infrastructure._4_3_blocking_queue.attention;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 恢复中断
 *
 * @author Luo Bao Ding
 */
public class BlockingQueueRecoverInterceptedStatusDemo {

    private BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);
    private BlockingQueue<Object> blockingQueue2 = new LinkedBlockingQueue<>();

    public void demo() {

        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
