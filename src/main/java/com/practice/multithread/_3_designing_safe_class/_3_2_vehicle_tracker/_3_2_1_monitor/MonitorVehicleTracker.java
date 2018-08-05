package com.practice.multithread._3_designing_safe_class._3_2_vehicle_tracker._3_2_1_monitor;

import com.practice.multithread._3_designing_safe_class._3_2_vehicle_tracker._3_2_1_monitor.domain.MutablePoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luo Bao Ding
 * @since 2018/8/4
 */
public class MonitorVehicleTracker {
    /**
     * final保证成员变量线程安全。注意：这不保证引用变量所引用的对象是线程安全的。<p>
     * 所以在put时要注意MutablePoint的处理，也需保证不变性,见方法{@link MonitorVehicleTracker#deepCopy(java.util.Map)}中的put处，新建了MutablePoint对象，没有改变原来的point
     */
    private final Map<String, MutablePoint> locations;


    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);//lkm

    }

    /**
     * API: 提供所有车辆的位置信息。<p>
     * for:<p>
     * 监控人员要能在大屏上看到所有车辆的位置
     */
    public synchronized Map<String, MutablePoint> getLocations() {
        /*返回快照*/
        return deepCopy(locations);
    }

    /**
     * API: 提供某一车辆的位置信息。<p>
     * for:<p>
     * 监控人员要能查看某一车辆的位置信息
     */
    public synchronized MutablePoint getLocation(String id) {
        MutablePoint point = locations.get(id);
        return point == null ? null : new MutablePoint(point);//lkm
    }

    /**
     * API: 设置车辆的位置信息。<p>
     * for:<p>
     * 车辆实时上传位置信息
     */
    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint point = locations.get(id);
        if (point == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        point.x = x;
        point.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> copy = new HashMap<>();
        for (Map.Entry<String, MutablePoint> entry : locations.entrySet()) {
            copy.put(entry.getKey(), new MutablePoint(entry.getValue()));//lkm
        }
        return copy;
    }
}
