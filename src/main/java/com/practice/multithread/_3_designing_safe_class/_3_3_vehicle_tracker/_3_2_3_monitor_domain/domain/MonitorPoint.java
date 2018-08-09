package com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_3_monitor_domain.domain;

/**
 *
 *
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
}
