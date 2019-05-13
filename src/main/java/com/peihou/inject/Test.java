package com.peihou.inject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    @org.junit.Test
    public void test()throws Exception{
        Class<Student> clazz= (Class<Student>) Class.forName("com.peihou.inject.Student");
        Field field=clazz.getDeclaredField("id");
        Method method=clazz.getDeclaredMethod("getId");
        ButterKnife knife=field.getAnnotation(ButterKnife.class);
        int id=knife.id();
        Student student=clazz.newInstance();
        int www=student.getId();
        if (id>0){
            field.setInt(student,id);
            int ss= (int) method.invoke(student);
            System.out.println("-->"+ss);
        }

        int ff=0xff;
        String sssss=Integer.toBinaryString(ff);
        System.out.println(sssss);
    }
}
