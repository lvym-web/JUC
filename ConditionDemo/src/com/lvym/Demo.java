package com.lvym;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Initdata{

    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();


    public void print(){
        lock.lock();
        try {
            while (number!=1){
              c1.await();
                          }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void print2(){
        lock.lock();
        try {
            while (number!=2){

             c2.await();

        }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void print3(){
        lock.lock();
        try {
            while (number!=3){
                    c3.await();


            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}



public class Demo {

    public static void main(String[] args) {
        Initdata initdata=new Initdata();
        new Thread(()->{initdata.print();},"a").start();
        new Thread(()->{initdata.print2();},"b").start();
        new Thread(()->{initdata.print3();},"c").start();
    }
}
