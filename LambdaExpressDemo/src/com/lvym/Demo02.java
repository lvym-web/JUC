package com.lvym;


import java.util.concurrent.TimeUnit;

class Phone{
/*
    public synchronized void sendEmail(){
        System.out.println("发送邮件");
    }

    public synchronized void sendSMS(){
        System.out.println("发送SMS");
    }*/
    public static synchronized void sendEmail(){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
    }

   public  void sendSMS(){
        System.out.println("发送SMS");
    }

}

/**
 * 一个对象里如果有多个synchronized修饰的方法，对象锁,锁的是对象，某一时刻如果有一个线程访问其中的一个方法，那么其他线程只能等待，普通方法不需要等待 ???????有疑问
 * 一个对象里如果有多个static synchronized修饰的方法，全局锁，锁的是class类
 */
public class Demo02 {

    public static void main(String[] args) throws Exception {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{phone.sendEmail();},"a").start();
        TimeUnit.MILLISECONDS.sleep(100);

        new Thread(()->{phone2.sendSMS();},"a").start();
    }
}
