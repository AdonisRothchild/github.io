package com.ad.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class TestLockDemo
{
    public static void main(String[] args) throws Exception
    {
        final CountDownLatch latch = new CountDownLatch(10);//有多少个线程这个参数就是几
        Runnable callable = () ->
        {
            try{
                for (int i = 0;i<20000;i++)
                {
                    System.out.println(Thread.currentThread().getName() + "输出语句:" + i);
                }
               // return Thread.currentThread().getName();
            }finally
            {
                latch.countDown();
            }

        };
        //FutureTask<String> fs = new FutureTask<String>(callable);
        long start = System.currentTimeMillis();
        for (int y = 0; y<10;y++)
        {
            System.out.println("第"+y+"次");
            new Thread(callable).start();
          // System.out.println(fs.get());
        }
        try {

            latch.await();//这10个线程执行完之前先等待
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        System.out.println("结束时间为" + (end-start));

    }

}
