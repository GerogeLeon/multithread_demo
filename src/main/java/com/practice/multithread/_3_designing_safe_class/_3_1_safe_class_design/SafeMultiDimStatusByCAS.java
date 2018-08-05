package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

import sun.misc.Unsafe;

/**
 * CAS: 乐观锁<br>
 * synchronized: 悲观锁<br>
 * {@link java.util.concurrent.atomic.AtomicInteger#incrementAndGet}
 */
public class SafeMultiDimStatusByCAS {

    private volatile int x;
    private volatile int y;

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    private static final long xFieldOffset;
    private static final long yFieldOffset;

    static {
        try {
            xFieldOffset = unsafe.objectFieldOffset(SafeMultiDimStatusByCAS.class.getDeclaredField("x"));
            yFieldOffset = unsafe.objectFieldOffset(SafeMultiDimStatusByCAS.class.getDeclaredField("y"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new Error(e);//lkm: must throw Error, prevent from vm forward
        }
    }

    public SafeMultiDimStatusByCAS(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int[] get() {
        return new int[]{x, y};
    }

    public void set(int x, int y) {
        int x0,y0;
        do {
            x0 = unsafe.getIntVolatile(this, xFieldOffset);
            y0 = unsafe.getIntVolatile(this, yFieldOffset);

        } while (!(unsafe.compareAndSwapInt(this, xFieldOffset, x0, x)
                && unsafe.compareAndSwapInt(this, yFieldOffset, y0, y)));

    }

}
