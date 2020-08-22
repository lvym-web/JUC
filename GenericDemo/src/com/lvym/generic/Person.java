package com.lvym.generic;

public class Person {
    private String name;
    private Integer age;

    public String a;
    protected String b;
     String c;
    private Integer d;

    public Person() {
    }


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d=" + d +
                '}';
    }

    public void aVoid(){
        System.out.println("aVoid");
    }
     void bVoid(){
        System.out.println("bVoid");
    }
    protected void cVoid(){
        System.out.println("cVoid");
    }
    public void aVoid(int in){
        System.out.println("aVoid "+in);
    }
    private void eVoid(){
        System.out.println("eVoid");
    }

}
