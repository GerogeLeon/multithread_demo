package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Luo Bao Ding
 */
public class MemoizerV3<A, V> implements Computable<A, V> {
    private final Map<A, FutureTask<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public MemoizerV3(Computable<A, V> computable) {
        this.computable = computable;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        FutureTask<V> futureResult = cache.get(arg);
        V result = null;
        if (futureResult == null) {
            futureResult = new FutureTask<>(() -> computable.compute(arg));
            cache.put(arg, futureResult);
            futureResult.run();//lkm: 可能重复计算
        }
        try {
            result = futureResult.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
/**
 * 重复计算
 */
