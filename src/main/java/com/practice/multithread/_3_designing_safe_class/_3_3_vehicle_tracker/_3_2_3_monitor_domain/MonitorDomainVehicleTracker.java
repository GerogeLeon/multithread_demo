package com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_3_monitor_domain;

import com.practice.multithread._3_designing_safe_class._3_3_vehicle_tracker._3_2_3_monitor_domain.domain.MonitorPoint;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * thread-safe
 *
 * @author Luo Bao Ding
 */
public class MonitorDomainVehicleTracker {

    private final ConcurrentHashMap<String, MonitorPoint> locations;
    private final Map<String, MonitorPoint> unmodifiableMap;

    public MonitorDomainVehicleTracker(Map<String, MonitorPoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, MonitorPoint> getLocations() {
        return unmodifiableMap;
    }

    public MonitorPoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        locations.get(id).set(x, y);

    }
}
