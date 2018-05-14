package com.compoent.entity;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        for(int i =0;i<5;i++){
            Person person = new Person();
            person.setId(String.valueOf(i));
            person.setName("name"+i);
            list.add(person);
        }

        Person p = new Person();
        p.setName("1");
        p.setId("1");

        System.out.println(p.equals(list.get(1)));
    }
}
