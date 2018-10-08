package com.peihou.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(100);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(80);
        int max=Collections.max(list);
        System.out.println("max:"+max);
    }
}
