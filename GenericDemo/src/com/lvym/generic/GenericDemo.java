package com.lvym.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class GenericDemo {
    public static void main(String[] args) {
       ArrayList<String> card=new ArrayList<>();
       card.add("大王");
       card.add("小王");
     String[] colors={"♠","♥","♣","♦"};
     String[] num={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String c : colors) {
            for (String n: num){
                card.add(c+n);
            }
        }
        //对指定列表进行置换   洗牌
        Collections.shuffle(card);
        //发牌
        List<String> player=new ArrayList<>();
        ArrayList<String> player02=new ArrayList<>();
        ArrayList<String> player03=new ArrayList<>();
        ArrayList<String> dipai=new ArrayList<>();
        for (int i=0;i<card.size();i++){
            String s = card.get(i);
            if (i%3==0){
                player.add(s);
            }
            if (i%3==1){
                player02.add(s);
            }
            if (i%3==2){
                player03.add(s);
            }
            if (i>=51){
                dipai.add(s);
            }
        }
        System.out.println("华仔："+player);
        System.out.println("星仔："+player02);
        System.out.println("发仔："+player03);
        System.out.println("底牌: "+ dipai);

    }


    public static void select(ArrayList<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

}
