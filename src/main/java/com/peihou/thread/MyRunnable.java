package com.peihou.thread;

import org.apache.log4j.spi.LoggerFactory;

import java.util.logging.Logger;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("threadName:->"+Thread.currentThread().getName()+",i="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
