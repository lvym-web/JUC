package com.lvym;


/**
 * 懒汉式
 *   有延迟，需要就去调用创建  安全  因为他是在内部类加载和初始化时，创建的
 *    1.构造器私有化，保证一个类只能有一个实例
 *    2.自行创建，并且用静态变量保存
 *    3.向外暴露这个实例
 *   内部类被加载和初始化时，才会创建INSTANCE实例对象，
 *   静态内部类不会随着外部类的加载和初始化而初始化，它是要单独加载和初始化。
 *
 *
 */
public class SingletonDemo {


   private SingletonDemo(){}
   //内部类
  private static class Inner{
       private final static SingletonDemo INSTANCE=new SingletonDemo();
  }
 public static SingletonDemo getInstance(){
       return Inner.INSTANCE;
 }
}
