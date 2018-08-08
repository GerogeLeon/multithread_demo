package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Luo Bao Ding
 */
public class MemoizerV4<A, V> implements Computable<A, V> {
    private final Map<A, FutureTask<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public MemoizerV4(Computable<A, V> computable) {
        this.computable = computable;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            FutureTask<V> futureResult = cache.get(arg);
            V result = null;
            if (futureResult == null) {
                futureResult = new FutureTask<>(() -> computable.compute(arg));
                FutureTask<V> previous = cache.putIfAbsent(arg, futureResult);
                if (previous == null) {
                    futureResult.run();
                }
            }
            try {
                result = futureResult.get();
            } catch (ExecutionException e) {
                cache.remove(arg, futureResult);
                throw new RuntimeException(e);
            }
            return result;
        }
    }
}
/**
 * 重复计算
 */
