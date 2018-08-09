package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 官方版：<p>
 * org.apache.commons.lang3.concurrent.Memoizer
 * <pre>{@code
 * <dependency>
 *     <groupId>org.apache.commons</groupId>
 *     <artifactId>commons-lang3</artifactId>
 *     <version>3.7</version>
 * </dependency>
 * }</pre>
 *
 * @param <A> 入参
 * @param <V> 结果
 */
public class MemoizerV5<A, V> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;
    private final boolean recalculate;

    public MemoizerV5(final Computable<A, V> computable) {
        this(computable, false);
    }

    public MemoizerV5(final Computable<A, V> computable, final boolean recalculate) {
        this.computable = computable;
        this.recalculate = recalculate;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                final FutureTask<V> futureTask = new FutureTask<>(() -> computable.compute(arg));
                future = cache.putIfAbsent(arg, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (final CancellationException e) {
                cache.remove(arg, future);
            } catch (final ExecutionException e) {
                if (recalculate) {
                    cache.remove(arg, future);
                }

                throw launderException(e.getCause());
            }
        }
    }

    private RuntimeException launderException(final Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        } else if (throwable instanceof Error) {
            throw (Error) throwable;
        } else {
            throw new IllegalStateException("Unchecked exception", throwable);
        }
    }
}
