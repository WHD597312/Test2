package com.peihou.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecute {
    int corePoolSize;//核心线程池中任务的数量
    int maxinumPoolSize;//线程池中的任务数量上限
    int keepAliveTimer,TimeUnit;//非核心线程的最长时间,超过这个时间将被解雇
    BlockingQueue<Runnable> workQueue;//排期排队
    ThreadFactory threadFactory;//线程产生去掉
    RejectedExecutionHandler handler;//拒单方式

    private static ExecutorService executorService= Executors.newFixedThreadPool(20);
    private static volatile AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void main(String[] args){
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(atomicInteger);
    }
}
