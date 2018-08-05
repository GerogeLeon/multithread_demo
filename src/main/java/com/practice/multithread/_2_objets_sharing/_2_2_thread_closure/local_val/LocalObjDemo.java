package com.practice.multithread._2_objets_sharing._2_2_thread_closure.local_val;

import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.UnsafeDemo;
import com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.domain.UnsafeSequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 局部变量
 * <p>
 * 对比:{@link UnsafeDemo}, {@link UnsafeContractForLocalObjDemo}
 *
 * <p>
 * 此例线程安全除了本地变量外，还有一个原因是unsafeSequence引用封闭在所属线程中, 逸出例子见{@link UnsafeContractForLocalObjDemo2}
 * </p>
 */
public class LocalObjDemo {

    public static void main(String[] args) {
        Runnable runnable = () -> {
//lkm local val
            UnsafeSequence unsafeSequence = new UnsafeSequence();
            try {
                for (int i = 0; i < 10; i++) {
                    unsafeSequence.incr();

                    Thread.sleep(10);

                    unsafeSequence.decr();
                    Thread.sleep(10);

                    System.out.println("val = " + unsafeSequence.getValue());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(runnable);
        }

        threadPool.shutdown();

    }

}
