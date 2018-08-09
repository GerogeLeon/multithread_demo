package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design.consistency;

/**
 * @author Luo Bao Ding
 */
public class WeakConsistencyPosition {

    private int x, y;

    public WeakConsistencyPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }
}
