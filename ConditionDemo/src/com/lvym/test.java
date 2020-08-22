package com.lvym;

import java.util.concurrent.*;

public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


     Callable<SingletonDemo> callable=new Callable<SingletonDemo>() {
         @Override
         public SingletonDemo call() throws Exception {
             return SingletonDemo.getInstance();
         }
     };
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Future<SingletonDemo> submit = executorService.submit(callable);
        Future<SingletonDemo> submit1 = executorService.submit(callable);

        System.out.println(submit.get());
        System.out.println(submit1.get());

        executorService.shutdown();


//        int i=1;
//        i=i++;   //先算等号右边：把i压入栈，i=1，i自增，局部变量i=2，再算等号左边：把栈值 1 赋给i，i=1.
//        int j=++i+i+ i++;// 先算等号右边：把i压入栈，i=1，i自增，局部变量i=2，再算等号左边：把栈值 1 赋给j，j=1.
//        int k=i+ ++i*i++;// 先算等号右边：把i压入栈，i=2,i自增,i=3压入栈，i自增，局部变量i=4，再把乘号右边i=3压入栈，栈中数据有  1 3 3，先算乘法3*3=9，还没有结束，所以再把9压入栈进行计算k=9+2=11
//        System.out.println(i);//4
//        System.out.println(j);//1
//        System.out.println(k);//11
    }
}
