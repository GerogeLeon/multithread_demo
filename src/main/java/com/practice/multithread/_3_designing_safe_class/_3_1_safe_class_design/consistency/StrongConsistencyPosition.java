package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design.consistency;

/**
 * 地理坐标x,y
 *
 *
 */
public class StrongConsistencyPosition {

    private int x, y;

    public StrongConsistencyPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
