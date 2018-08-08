package com.practice.multithread._4_infrastructure._4_2_concurrent_container._4_2_5_future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 点大盘鸡外卖，然后等大盘鸡
 *
 * @author Luo Bao Ding
 */
public class FutureTaskDemo {

    public void demo()  {
        //饭店外卖服务
        Callable<String> restaurantService=()->{
            System.out.println("大盘鸡已做好，开始派送");
            System.out.println("派送中。。。。。。。。");
            Thread.sleep(2000);
            return "大盘鸡";
        };
        FutureTask<String> order = new FutureTask<>(restaurantService);

        System.out.println("开始下单");
        new Thread(order).start();
        System.out.println("下单成功");
        String food = null;
        try {
            food = order.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("收到" + food);

    }

    public static void main(String[] args) {
        new FutureTaskDemo().demo();
    }
}
