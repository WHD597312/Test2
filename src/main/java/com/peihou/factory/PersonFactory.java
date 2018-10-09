package com.peihou.factory;

import com.peihou.pojo.Person;

public class PersonFactory {
    public static Person createFactory(){
        System.out.println("静态工厂创建对象");
        return new Person();
    }
    public Person createFactory2(){
        System.out.println("实例化创建对象");
        return new Person();
    }
}
