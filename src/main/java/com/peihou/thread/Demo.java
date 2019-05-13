package com.peihou.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private static final ExecutorService batchTachPool= Executors.newCachedThreadPool();
    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
            batchTachPool.execute(new MyRunnable());
        }
    }
}
