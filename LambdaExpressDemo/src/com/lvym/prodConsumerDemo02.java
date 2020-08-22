package com.lvym;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class InitData {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {

        lock.lock();
        try {
            //判断伴有循环
            while (number != 0) {
                System.out.println("----------------------------increment循环" + Thread.currentThread().getName());

                condition.await();

            }
            //干活
            number ++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //        //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() {
        lock.lock();

        try {
            //判断伴有循环
            while (number == 0) {
                System.out.println("----------------------------increment循环" + Thread.currentThread().getName());

                condition.await();

            }
            //干活
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //        //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


public class prodConsumerDemo02 {
    public static void main(String[] args) {
        InitData initData = new InitData();
        new Thread(() -> {
            for (int i = 1; i < 42; i++) {
                initData.increment();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 1; i < 42; i++) {
                initData.decrement();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 1; i < 42; i++) {
                initData.increment();
            }
        }, "c").start();
        new Thread(() -> {
            for (int i = 1; i < 42; i++) {
                initData.decrement();
            }
        }, "d").start();
    }


}
