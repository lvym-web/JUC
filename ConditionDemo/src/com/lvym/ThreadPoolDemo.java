package com.lvym;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    /**
     *线程池的优势：
     * 线程池做的工作主要是
     *          控制运行的线程数量，
     *          处理过程中将任务放入队列，
     *          然后在线程创建后启动这些任务，
     *          如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
     *
     * 它的主要特点为：线程复用;控制最大并发数;管理线程。
     *
     * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
     * 第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
     * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
     *
     * 四种拒绝策略：
     *      AbortPolicy(默认)：直接抛出RejectedExecutionException异常阻止系统正常运行.(超过maximumPoolSize+队列数就触发)
     *      CallerRunsPolicy：“调用者运行”一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
     *      DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中尝试再次提交当前任务.
     *      DiscardPolicy：该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种策略。
     *
     *
     *     CPU密集型：
     *        maximumPoolSize=CPU核数+1或+2
     *          System.out.println(Runtime.getRuntime().availableProcessors());得到CPU核数
     *
     *
     *     IO密集型：
     *        可能为：不确定：
     *         maximumPoolSize=CPU核数/总核数/阻塞系数（线程花在系统IO上的时间与中央处理器密集任务所耗时间比值）
     *
     *
     * @param args
     */
    public static void main(String[] args) {



        ExecutorService executorService=new ThreadPoolExecutor(2,
                5,
                3L,TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        int count=0;
        try {

            for (int i = 0; i < 10; i++) {
                //TimeUnit.SECONDS.sleep(1);
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
         count ++;
            executorService.shutdown();
            System.out.println("-------"+count+"-----");
        }


         //实际开发中都不用jdk自带，而用自定义
       // ExecutorService executorService= Executors.newFixedThreadPool(6);//固定线程链接数
     //   ExecutorService executorService= Executors.newSingleThreadExecutor();//一个
      //  ExecutorService executorService= Executors.newCachedThreadPool();//多个
   //     ExecutorService executorService= Executors.newScheduledThreadPool(3);

       /* try {
          for (int i = 0; i < 10; i++) {
             //TimeUnit.SECONDS.sleep(1);
              executorService.execute(() -> {
                  System.out.println(Thread.currentThread().getName() + "\t 办理业务");
              });
          }
      }catch (Exception e){
          e.printStackTrace();
      }finally {

          executorService.shutdown();
          System.out.println("------------");
      }
*/

    }

}
