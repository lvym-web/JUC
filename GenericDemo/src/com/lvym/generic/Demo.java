package com.lvym.generic;



public class Demo extends Thread{

    @Override
    public void run() {
        for (int i=1;i<20;i++){
            System.out.println(currentThread().getName()+":demo="+i);
        }
    }
}
