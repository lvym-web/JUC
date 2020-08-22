package com.lvym;
@FunctionalInterface
interface Mytest{

    // void my();
     int test(int x,int y);

     default int a(){
         return 0;
     }
    default int b(int x,int y){
        return x+y;
    }
     static String c(){
         return "ccc";
    }
    static String d(String a){
        return a;
    }


}


/**
 * 函数式接口   里面只声明一个方法就是函数式接口，其自带隐式 @FunctionalInterface
 *                  可以有多个方法实现   default    static  修饰
 */
public class Demo {

    public static void main(String[] args) {

       /* Mytest mytest=new Mytest() {
            @Override
            public void my() {
                System.out.println("-------my----------");
            }
        };
        mytest.my();*/

      /*
        Mytest mytest=()-> System.out.println("-------my----------");
        mytest.my();*/

   /*   Mytest mytest2=new Mytest() {
          @Override
          public int test(int x, int y) {

              return x * y;
          }
      };
        System.out.println(mytest2.test(3, 6));*/
        Mytest mytest2=(x,y)->{return x * y; };

        System.out.println(mytest2.test(3, 6));

        int i = mytest2.b(1, 2);
        System.out.println("-----default方法-----"+i);

        String d = Mytest.d("0000");
        System.out.println("------statis方法----"+d);
    }

}
