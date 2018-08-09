package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 比较完美版。可改进处：健全异常处理
 *
 *
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
            FutureTask<V> future0 = cache.get(arg);
            V result = null;
            if (future0 == null) {
                FutureTask<V> future1 = new FutureTask<>(() -> computable.compute(arg));
                future0 = cache.putIfAbsent(arg, future1);
                if (future0 == null) {
                    future0 = future1;
                    future1.run();
                }

            }
            try {
                result = future0.get();
            } catch (ExecutionException e) {//异常处理不健全
                cache.remove(arg, future0);
                throw new RuntimeException(e);
            }
            return result;
        }
    }
}
/**
 * 重复计算
 */
