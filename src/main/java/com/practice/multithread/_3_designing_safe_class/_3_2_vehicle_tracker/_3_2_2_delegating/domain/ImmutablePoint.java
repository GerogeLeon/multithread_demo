package com.practice.multithread._3_designing_safe_class._3_2_vehicle_tracker._3_2_2_delegating.domain;

/**
 * safe
 *
 */
public class ImmutablePoint {
    private final int x, y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
