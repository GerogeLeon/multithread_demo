package com.practice.multithread._1_thread_safe._1_1_demo._1_1_2_multi_val.domain;

/**
 * unsafe:<p>
 *     其中每个方法是原子的，但是仅是原子地的操作position对象的一部分，即一个坐标，这导致这个对象不是线程安全的
 *
 */
public class UnsafeCarPosition {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
