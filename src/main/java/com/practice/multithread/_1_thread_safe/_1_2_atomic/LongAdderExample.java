package com.practice.multithread._1_thread_safe._1_2_atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


/**
 * @author Luo Bao Ding
 */
public class LongAdderExample {
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable incrementAction = () -> IntStream
                .range(0, numberOfIncrements)
                .forEach(i -> counter.increment());

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(incrementAction);
        }
        try {
            executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
            executorService.shutdown();

            assertEquals(counter.sum(), numberOfIncrements * numberOfThreads);

            assertEquals(counter.sumThenReset(), numberOfIncrements * numberOfThreads);
            assertEquals(counter.sum(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
