package com.practice.multithread._1_thread_safe._1_1_demo._1_1_2_multi_val;

import com.practice.multithread._1_thread_safe._1_1_demo._1_1_2_multi_val.domain.UnsafeCarPosition;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 只锁住了一处：读
 *
 *
 *
 */
public class UnsafeCarPositionDemo3 {
    private ConcurrentHashMap<String, UnsafeCarPosition> locations = new ConcurrentHashMap<>();


    public void demo() {
        final Random random = new Random();

        Runnable updatePosition = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int posVal = random.nextInt(100);
                    String id = "id" + i;
                    UnsafeCarPosition carPosition = locations.computeIfAbsent(id, s -> new UnsafeCarPosition());

                    carPosition.setX(posVal);
                    Thread.sleep(1);
                    carPosition.setY(posVal);
                    Thread.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        for (int i = 0; i < 20; i++) {
            new Thread(updatePosition).start();
        }
        startPrinting();


    }

    private void startPrinting() {

        Runnable printPosition = () -> {
            try {
                Set<Map.Entry<String, UnsafeCarPosition>> entries = locations.entrySet();
                for (Map.Entry<String, UnsafeCarPosition> entry : entries) {
                    UnsafeCarPosition carPosition = entry.getValue();
                    int x;
                    int y;
                    synchronized (carPosition) {
                        x = carPosition.getX();
                        y = carPosition.getY();
                    }
                    System.out.println(entry.getKey() + ":\t" + x + ",\t" + y);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        for (int i = 0; i < 20; i++) {
            new Thread(printPosition).start();
        }
    }

    public static void main(String[] args) {
        new UnsafeCarPositionDemo3().demo();
    }
}
