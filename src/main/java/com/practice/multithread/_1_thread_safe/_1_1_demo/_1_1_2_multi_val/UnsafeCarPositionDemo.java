package com.practice.multithread._1_thread_safe._1_1_demo._1_1_2_multi_val;

import com.practice.multithread._1_thread_safe._1_1_demo._1_1_2_multi_val.domain.UnsafeCarPosition;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;


/**
 *
 */
public class UnsafeCarPositionDemo {
    private ConcurrentHashMap<String, UnsafeCarPosition> locations = new ConcurrentHashMap<>();


    public void demo() {
        final Random random = new Random();

        Runnable updatePosition = () -> {
            try {
                //不断更新位置信息
                for (int i = 0; i < 10; i++) {
                    int posVal = random.nextInt(100);
                    String id = "id" + i;
                    UnsafeCarPosition carPosition = locations.computeIfAbsent(id, s -> new UnsafeCarPosition());
                    //每次设置相同的值，预期始终x==y
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

        //不断打印位置信息
        startPrinting();


    }

    private void startPrinting() {

        Runnable printPosition = () -> {
            try {
                Set<Map.Entry<String, UnsafeCarPosition>> entries = locations.entrySet();
                for (Map.Entry<String, UnsafeCarPosition> entry : entries) {
                    System.out.println(entry.getKey() + ":\t" + entry.getValue().getX() + ",\t" + entry.getValue().getY());
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
        new UnsafeCarPositionDemo().demo();
    }
}
