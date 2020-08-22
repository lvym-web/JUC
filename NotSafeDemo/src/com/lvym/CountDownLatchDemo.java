package com.lvym;


import java.util.concurrent.CountDownLatch;

/**
 * 按照顺序   当new CountDownLatch(6);的值减到0就走countDownLatch.await();
 *
 *  * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 *  * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 *  * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "离开教室");
                countDownLatch.countDown();//减一
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();//减到0就走
        System.out.println(Thread.currentThread().getName() + "\t" + "离开教室");
    }
}
