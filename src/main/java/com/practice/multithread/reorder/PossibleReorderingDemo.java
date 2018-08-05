package com.practice.multithread.reorder;

/**
 * 得不出重排序的差别，因为重排序不能影响结果
 */
public class PossibleReorderingDemo {

    private volatile int status1, status2, status3, status4, status5;

    private Object biz1, biz2, biz3, biz4, biz5;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new PossibleReorderingDemo().demo();
        }

    }

    private void demo() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                if (status5 == 1) {
                    biz5 = new Object();
                }
                Thread.sleep(10);

                if (status4 == 1) {
                    biz4 = new Object();
                }

                Thread.sleep(10);

                if (status3 == 1) {
                    biz3 = new Object();
                }

                Thread.sleep(10);

                if (status2 == 1) {
                    biz2 = new Object();
                }

                Thread.sleep(10);

                if (status1 == 1) {
                    biz1 = new Object();
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread2 = new Thread(() -> {
            status1 = 1;
            sleep(10);
            status2 = 1;
            sleep(10);
            status3 = 1;
            sleep(10);
            status4 = 1;
            sleep(10);
            status5 = 1;
        });

        thread1.start();
        thread2.start();

        Thread.sleep(50);

        thread1.join();
        thread2.join();
        System.out.println("(" + (biz5 != null) + "," + (biz4 != null) + "," + (biz3 != null) + "," + (biz2 != null) + "," + (biz1 != null) + ")");
    }

    public void sleep(long l){

        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
