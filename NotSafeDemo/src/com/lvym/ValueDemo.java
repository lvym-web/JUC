package com.lvym;

class InitValue{

    public void test(int age){
        age=313;
    }
    public int test2(int age){
       return age=353;
    }
    public void test3(Person person){
        person.setName("00000000");
    }
    public void test4(String string){
        string="0000000";
    }
}

/**
 * 基本类型传复印件，原件未改
 */
public class ValueDemo {
    public static void main(String[] args) {
        InitValue initValue=new InitValue();
        int age=33;
     //   initValue.test(age);
        initValue.test2(age);
        System.out.println("age:"+age);//   33

        Person person=new Person("aa"); //传引用地址
        initValue.test3(person);
        System.out.println(person.getName());//0000000

        String s="aaa";  //存在常量池    池里有配对就返回，没有就新建
        initValue.test4(s);//引用地址改变了
        System.out.println(s);  //aaa

    }
}


class Person{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
}