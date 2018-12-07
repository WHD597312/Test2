package com.peihou.reflect;

import java.lang.reflect.Method;

public class Test {

    @org.junit.Test
    public void test(){
        try {
            Class<Father> clazz= (Class<Father>) Class.forName("com.peihou.reflect.Father");
            Method method=clazz.getDeclaredMethod("say",String.class);
            method.setAccessible(true);
            String s= (String) method.invoke(clazz.newInstance(),"我的爸爸");
            System.out.println("sss:"+s);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
