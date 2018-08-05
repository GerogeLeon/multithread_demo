package com.practice.multithread._2_objets_sharing._2_3_immutable;

import com.practice.multithread._2_objets_sharing._2_3_immutable.domain.MutableLastLeavingPerson;

/**
 * 功能：记录最后打卡时间。
 *
 * 分析：有窜改机会
 *
 * @author Luo Bao Ding
 */
public class UnsafeMutableDemo {
    private volatile MutableLastLeavingPerson lastLeavingPerson;

    {
        lastLeavingPerson = new MutableLastLeavingPerson();
        lastLeavingPerson.setName("");
        lastLeavingPerson.setLeavingTime(-1);

    }

    /***
     * 不断地打卡
     */
    class MyThread extends Thread {


        private final int time;

        MyThread(int time) {
            this.time = time;
        }


        @Override
        public void run() {
            int time = this.time;
            for (int i = 0; i < 50; i++) {
                time++;
                updateLastLeavingPerson("a" + time, time);
                time++;
                updateLastLeavingPerson("b" + time, time);
                time++;
                updateLastLeavingPerson("c" + time, time);
                time++;
                updateLastLeavingPerson("e" + time, time);
                time++;
                updateLastLeavingPerson("f" + time, time);
            }

        }


    }

    public void demo() {
        try {

            int baseTime = 0;
            //模拟很多人打卡
            for (int i = 0; i < 10; i++) {
                new MyThread(baseTime).start();
                baseTime += 100;
            }

            startPrinting();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 不断的打印最新最后走的人
     */
    private void startPrinting() {
        Runnable print = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    printLastLeavingPerson();
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        for (int i = 0; i < 10; i++) {
            new Thread(print).start();
        }
    }

    private void updateLastLeavingPerson(String name, Integer time) {
        try {
            if (time > lastLeavingPerson.getLeavingTime()) {
                lastLeavingPerson.setName(name);
                Thread.sleep(10);
                lastLeavingPerson.setLeavingTime(time);
                Thread.sleep(10);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printLastLeavingPerson() {
        System.out.println(lastLeavingPerson.toString());
    }

    public static void main(String[] args) {
        new UnsafeMutableDemo().demo();
    }
}
