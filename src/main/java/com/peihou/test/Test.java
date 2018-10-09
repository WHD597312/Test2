package com.peihou.test;

import com.peihou.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.UUID;

public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        Person person= (Person) ac.getBean("person");
        System.out.println(person);
    }
    @org.junit.Test
    public void test2(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        Person person2= (Person) ac.getBean("person2");
        System.out.println(person2);
    }
    @org.junit.Test
    public void test3(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        Person person3= (Person) ac.getBean("person3");
        System.out.println(person3);
    }
    @org.junit.Test
    public void getUUID(){
        String uuid=UUID.randomUUID().toString();
        uuid=uuid.replaceAll("-","");
        System.out.println(uuid);
        Random random=new Random();
        int x=random.nextInt(10);
        System.out.println("size:"+uuid.length());
        System.out.println("x="+x);
    }
}
