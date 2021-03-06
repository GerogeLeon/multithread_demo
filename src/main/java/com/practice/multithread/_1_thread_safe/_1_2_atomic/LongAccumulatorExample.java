package com.practice.multithread._1_thread_safe._1_2_atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * 累计器，可以定制累计算法。原理：按线程分散存储，取值时对分散的值累计。吞吐量高于AtomicLong
 *
 */
public class LongAccumulatorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0L);
        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable accumulateAction = () -> IntStream
                .rangeClosed(0, numberOfIncrements)
                .forEach(accumulator::accumulate);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(accumulateAction);
        }
        try {
            executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
            executorService.shutdown();
            assertEquals(accumulator.get(), 20200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
