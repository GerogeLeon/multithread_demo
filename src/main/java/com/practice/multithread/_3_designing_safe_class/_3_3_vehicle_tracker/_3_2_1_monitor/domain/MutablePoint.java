package com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_1_monitor.domain;

/**
 * not safe. 可能出现点A(x1,y2),其中y2为另一个点的
 *
 *
 *
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        this.x = 0;
        this.y = 0;
    }

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(MutablePoint point) {
        this.x = point.x;
        this.y = point.y;
    }

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
