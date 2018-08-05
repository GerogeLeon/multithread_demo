package com.practice.multithread._3_designing_safe_class._3_2_vehicle_tracker._3_2_3_monitor_domain.domain;

/**
 * @author Luo Bao Ding
 * @since 2018/8/4
 */
public class MonitorPoint {
    private int x, y;

    public MonitorPoint(int x, int y) {
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

/*//    ------------- lkm: not safe, why ? ---------
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
   */
}
