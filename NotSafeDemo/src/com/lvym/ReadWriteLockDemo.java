package com.lvym;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class My{

    private volatile Map<String,Object> hashMap=new HashMap<>();

    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();//创建读写锁

    public void put(String key,Object value){

      readWriteLock.writeLock().lock();//写锁
        try {
            System.out.println(Thread.currentThread().getName()+"\t  写入数据");
            TimeUnit.MILLISECONDS.sleep(200);
            hashMap.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();//释放
        }


    }
    public Object get(String key){

      readWriteLock.readLock().lock();//读锁
        Object result =null;
        try {
            System.out.println(Thread.currentThread().getName()+"\t  读取数据"+key);
            TimeUnit.MILLISECONDS.sleep(200);
             result = hashMap.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();//释放
        }


        return result;
    }


}

/**
 *写锁：只能有一个线程，读锁：共享资源
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        My my=new My();

        for (int i = 0; i < 6; i++) {
            final int temp=i;
            new Thread(()->{my.put("a"+temp+"",temp);},String.valueOf(i)).start();
        }
        for (int i = 0; i < 6; i++) {
            final int temp=i;
            new Thread(()->{
                my.get("a" + temp + "");

            },String.valueOf(i)).start();
        }
    }
}
