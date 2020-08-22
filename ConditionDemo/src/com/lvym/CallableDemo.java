package com.lvym;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyCallable implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        System.out.println("进入Callable");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("进入Runnable");
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("进入Thread");
       // super.run();
    }
}

/**
 *     Thread底层没有Callable的构造
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyCallable());

//        System.out.println("-----"); //   1
//        new Thread(futureTask,"a").start();
//        // new Thread(futureTask,"b").start();//不会再打印一次
//        System.out.println("--2---");//   2
//        System.out.println(futureTask.get());//   3

//        System.out.println("-----"); //   1
//        new Thread(futureTask,"a").start();
//       // new Thread(futureTask,"b").start();//不会再打印一次
//        System.out.println(futureTask.get());//   2
//        System.out.println("--2---");//   3


      /*  Thread thread=new Thread(new MyRunnable());
        thread.start();*/

        Thread thread2=new Thread(new MyThread());
        System.out.println(".............");//   1
        thread2.start();//  3
        System.out.println("......2......."); //   2


        new Thread(()->{System.out.println("进入Runnable");},"a").start();

    }
}
