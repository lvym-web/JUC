package com.lvym;


import java.util.Random;

/**
 * 实际生产环境：   -Xms   -Xmx 配置成一样大小，避免内存忽高忽低产生停顿，避免GC和应用程序争抢内存，理论值  峰值  峰组 ，忽高忽低
 */
public class Demo {
    public static void main(String[] args) {
//        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
//        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
//        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
//        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");

       // System.out.println(Runtime.getRuntime().availableProcessors());

        String str = "www.lvym.com" ;
        while(true)
        {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
        }





    }
}
