package com.lvym;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("c"));//报错  Exception in thread "main" java.lang.IllegalStateException: Queue full

//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
       // System.out.println(blockingQueue.remove());//报错  java.util.NoSuchElementException
        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());
    }
}
