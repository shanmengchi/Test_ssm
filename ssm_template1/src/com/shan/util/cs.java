package com.shan.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class cs {

	public static void main(String[] args) {
        final Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("11111111111");
        queue.add("22222222222");
        queue.add("33333333333");
        queue.add("44444444444444");
        queue.add("555555555555555");
        queue.add("666666666666666");
        queue.add("7777777777777");
 
       final long start = System.currentTimeMillis();
        System.out.println("start:"+start);
 
        for(int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (queue.size() > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String value = queue.poll();
                        if(value != "" && null != value)
                            System.out.println(Thread.currentThread().getName() + "------------ " + value);
                        long end=System.currentTimeMillis();
                        System.out.println(Thread.currentThread().getName()+":"+(end-start));
                    }
 
 
                }
            }).start();
        }
    }

}
