package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

/**
 * 多维度状态类，各元一致性。<p>线程安全技术：copy, synchronized</p>
 * <p>{@link java.util.concurrent.CopyOnWriteArrayList#add(E)}</p>
 */
public class SafeMultiDimStatusByCopy {
    private int x, y;

    public SafeMultiDimStatusByCopy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * synchronized + copy
     */
    public synchronized int[] get() {
        return new int[]{x,y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
