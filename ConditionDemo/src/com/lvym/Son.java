package com.lvym;

/**成员变量有默认值
 * 局部变量没有默认值
 *
 */
public class Son {
    static int s;//成员变量，类变量 s
    int i; //成员变量，实例变量 i
    int j;//成员变量，实例变量 j

    { //非静态代码块   作用域开始
        int i=1; //局部变量 i
        i++; //i代表局部变量 i  就近原则
      //  this.i++;   //i代表//成员变量 i
        j++;  //j代表成员变量 j   就近 原则
        s++;
    }     //作用域结束
    public void test(int j){//局部变量 j     作用域开始
        j++;
        i++;
        s++;
    }   //作用域结束
       public static void main(String[] args) {
        Son son=new Son();
        Son son2=new Son();
        son.test(10);
        son.test(20);
        son2.test(10);
           System.out.println(son.i+" ,"+son.j+" ,"+son.s);
           System.out.println(son2.i+" ,"+son2.j+" ,"+son2.s);
    }
}