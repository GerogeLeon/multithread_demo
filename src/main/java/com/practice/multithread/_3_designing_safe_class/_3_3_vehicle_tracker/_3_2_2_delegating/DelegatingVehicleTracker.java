package com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_2_delegating;

import com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_2_delegating.domain.ImmutablePoint;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * thread-safe <p>
 * 各方法没有使用synchronized <p>
 * 委托安全容器ConcurrentHashMap+不变基元ImmutablePoint
 *
 * @author Luo Bao Ding
 * @since 2018/8/4
 */
public class DelegatingVehicleTracker {
    /**
     * ConcurrentHashMap支持并发读写， 所以getLocation与setLocation都要使用这个
     * 其中String与ImmutablePoint都是不可变的
     */
    private final ConcurrentHashMap<String, ImmutablePoint> locations;
    private final Map<String, ImmutablePoint> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, ImmutablePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, ImmutablePoint> getLocations() {
        return unmodifiableMap;
    }

    public ImmutablePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new ImmutablePoint(x, y)) == null) {
            locations.putIfAbsent(id, new ImmutablePoint(x, y));
        }
    }

}
