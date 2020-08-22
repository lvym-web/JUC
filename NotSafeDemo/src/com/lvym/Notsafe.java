package com.lvym;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 多线程：
 *     ArrayList不安全
 *       报错   Exception in thread "0" java.util.ConcurrentModificationException
 *        解决方法：new Vector<>();  /   Collections.synchronizedList(new ArrayList<>());  /
 *                高并发建议使用： new CopyOnWriteArrayList<>();每次写数据的时候都会先复制当前容器，往里写数据，写完没问题之后，替换之前容器， 读写是分离的，其底层加了可重入锁
 *
 *     HashSet:
 *       底层是Hashmap,
 *       add方法：
 *
 *       public boolean add(E e) {
 *         return map.put(e, PRESENT)==null;
 *     }
 *      // Dummy value to associate with an Object in the backing Map
 *     private static final Object PRESENT = new Object();
 *
 *     报错：java.util.ConcurrentModificationException
 *     解决：new CopyOnWriteArraySet<>();
 *
 *     HashMap:
 *          报错：java.util.ConcurrentModificationException
 *      解决：new ConcurrentHashMap<>();
 *
 */
public class Notsafe {

    public static void main(String[] args) {
       // list();
        //set();
        map();

    }

    private static void map() {
        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i=1;i<=12;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,6));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    private static void set() {
        Set<String> set=new CopyOnWriteArraySet<>();
        for (int i=1;i<=12;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    private static void list() {
        List<String> list=new CopyOnWriteArrayList<>(); //Collections.synchronizedList(new ArrayList<>());//new Vector<>();   //new ArrayList();
//        list.add("a");
//        list.add("b");
//        list.add(UUID.randomUUID().toString().substring(0,8));
//        list.forEach(System.out::println);


        for (int i=0;i<3;i++){
            new Thread(()->{
             list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
