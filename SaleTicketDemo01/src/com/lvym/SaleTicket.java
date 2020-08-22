package com.lvym;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number=30;

 Lock lock=new ReentrantLock();

 public void sale(){
     lock.lock();
     try {
         if (number>0){
             System.out.println(Thread.currentThread().getName()+"卖出第"+(number--)+"票，剩余："+number);
         }

     }catch (Exception e){
         e.printStackTrace();
     }finally {
         lock.unlock();
     }
 }

}



public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();



        new Thread(()->{for (int i=1;i<=44;i++) ticket.sale();},"a").start();
        new Thread(()->{for (int i=1;i<=44;i++) ticket.sale();},"b").start();
        new Thread(()->{for (int i=1;i<=44;i++) ticket.sale();},"c").start();
       /* new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i=1;i<=44;i++){
                   ticket.sale();
               }
            }
        },"aaa").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=44;i++){
                    ticket.sale();
                }
            }
        },"bbb").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=44;i++){
                    ticket.sale();
                }
            }
        },"ccc").start();*/

    }


}
