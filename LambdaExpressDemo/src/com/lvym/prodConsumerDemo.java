package com.lvym;

import java.util.concurrent.TimeUnit;

class ShareDataOne{   //资源类

    private int number=0;

    public synchronized void increment() throws InterruptedException {
         //判断伴有循环
        if (number!=0){
            System.out.println("----------------------------increment循环"+Thread.currentThread().getName());
            this.wait();
        }
        //干活
        number ++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //        //通知
          this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        //判断伴有循环
        if (number==0){
            System.out.println("----------------------------decrement循环"+Thread.currentThread().getName());
            this.wait();
        }
        //干活
        number --;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();

    }
}


/**
 *   2.1  判断
 *     2.2  干活
 *      2.3  通知
 *   3 防止虚假唤醒用while
 */
public class prodConsumerDemo {
    public static void main(String[] args) {

        ShareDataOne shareDataOne=new ShareDataOne();

        new Thread(()->{
            for (int i=1;i<42;i++) {
                try {
                    shareDataOne.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"a").start();


        new Thread(()->{
            for (int i=1;i<42;i++) {
                try {

                      shareDataOne.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

        new Thread(()->{
            for (int i=1;i<42;i++) {
                try {
                    shareDataOne.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"c").start();


        new Thread(()->{
            for (int i=1;i<42;i++) {
                try {

                    shareDataOne.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"d").start();


    }
}
