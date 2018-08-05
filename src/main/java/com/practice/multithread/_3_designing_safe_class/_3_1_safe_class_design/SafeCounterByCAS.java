package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

import sun.misc.Unsafe;
/**
 * CAS: 乐观锁<br>
 * synchronized: 悲观锁<br>
 * {@link java.util.concurrent.atomic.AtomicInteger#incrementAndGet}
 */
public class SafeCounterByCAS {

    private volatile int count;

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long countFieldOffset;

    static {
        try {
            countFieldOffset = unsafe.objectFieldOffset(SafeCounterByCAS.class.getDeclaredField("count"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    public int get() {
        return count;
    }

    public void set(int val) {
        count = val;
    }

    public void increase() {
        int count0;
        do {
            count0 = unsafe.getIntVolatile(this, countFieldOffset);
        } while (!unsafe.compareAndSwapInt(this, countFieldOffset, count0, count0 + 1));
    }


}
