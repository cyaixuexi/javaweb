package com.cy.json;

import com.cy.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //1 javaBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1,"你好!");
        Gson gson = new Gson();
        //toJson方法可以吧java对象转化为Json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //fromJson吧Json字符转化java对象
        //第一个参数是json字符串
        //第二个参数是转化回去的java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }
    //2 List和json的互转
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1,"小鑫"));
        personList.add(new Person(2,"小明"));

        Gson gson = new Gson();
        //吧List转化为Json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);

        List<Person> list = gson.fromJson(personListJsonString,new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }
    //3 map和json的互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1,new Person(1,"小鑫"));
        personMap.put(2,new Person(2,"小张"));

        Gson gson = new Gson();
        //吧map集合转化为json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

//        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap2);
        Person p = personMap2.get(1);
        System.out.println(p);
    }
}
