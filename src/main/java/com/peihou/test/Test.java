package com.peihou.test;

import com.peihou.pojo.Orders;
import com.peihou.pojo.Person;
import com.peihou.pojo.User;
import com.peihou.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.List;
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
//        Person person2= (Person) ac.getBean("person2");
//        System.out.println(person2);
        UserService userService= (UserService) ac.getBean("userService");
        User user=userService.selectUserOrdersById2(2);
        List<Orders> orders=user.getOrdersList();
        for (Orders orders1:orders) {
            System.out.println(orders1);
        }
//        System.out.println(user);
    }
    @org.junit.Test
    public void test3(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        Person person3= (Person) ac.getBean("person3");
        System.out.println(person3);
    }
    @org.junit.Test
    public void getUUID(){
//        String uuid=UUID.randomUUID().toString();
//        uuid=uuid.replaceAll("-","");
//        System.out.println(uuid);
//        Random random=new Random();
//        int x=random.nextInt(10);
//        System.out.println("size:"+uuid.length());
//        System.out.println("x="+x);
        try {
            String s="{\"Warmer\":[144,1,1,240,40,252,1,0,127,0,0,0,0,0,0, 0,0, 0,0,0, 0,0,0,0,0,30,19,20, 21,25, 10,25,0,0,0,0,0,0,33,9]}";
            System.out.println(s);
            JSONObject jsonObject=new JSONObject(s);
            JSONArray jsonArray=jsonObject.getJSONArray("Warmer");
            int sum=0;
            for (int i = 0; i <38 ; i++) {
                sum=sum+jsonArray.getInt(i);
            }
            int check=sum%256;
            jsonArray.put(38,check);
            System.out.println(jsonArray);
            jsonObject.put("Warmer",jsonArray);
            System.out.println(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void test4(){
        try {
            Calendar calendar=Calendar.getInstance();
            int headCode=85;
            int effectTime=1;
            int year=calendar.get(Calendar.YEAR);
            int yearHigh=year/256;
            int yearLow=year%256;
            int month=calendar.get(Calendar.MONTH)+1;
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int week=calendar.get(Calendar.DAY_OF_WEEK);
            week=getWeek(week);
            int hour=calendar.get(Calendar.HOUR_OF_DAY);
            int min=calendar.get(Calendar.MINUTE);
            int second=calendar.get(Calendar.SECOND);
            int funCode=2;
            int sum=headCode+effectTime+yearHigh+yearLow+month+day+week+hour+min+second+funCode;
            int checkCode=sum%256;
            int endCode=136;
            JSONArray jsonArray=new JSONArray();
            jsonArray.put(0,headCode);
            jsonArray.put(1,effectTime);
            jsonArray.put(2,yearHigh);
            jsonArray.put(3,yearLow);
            jsonArray.put(4,month);
            jsonArray.put(5,day);
            jsonArray.put(6,week);
            jsonArray.put(7,hour);
            jsonArray.put(8,min);
            jsonArray.put(9,second);
            jsonArray.put(10,funCode);
            jsonArray.put(11,checkCode);
            jsonArray.put(12,endCode);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("Warmer",jsonArray);
            String s=jsonObject.toString();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void test5(){
        try {
            String s="{\n" +
                    "\t\"Warmer\": [60, 0, 2, 68, 16, 17, 31, 255, 7, 129, 255, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 1, 2, 3, 4, 30, 156, 154, 149, 0, 0, 0, 99, 70]\n" +
                    "}";

            JSONObject jsonObject = new JSONObject(s);
//            JSONArray jsonArray=new JSONArray(jsonObject);
            JSONArray jsonArray=jsonObject.getJSONArray("Warmer");
            int sum=0;
            for (int i = 0; i <jsonArray.length()-2 ; i++) {
                sum=sum+jsonArray.getInt(i);
            }
            sum=sum%256;
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 得到某一天的星期几
     * @return
     */
    public  int getWeek(int week){
        int mWeek=0;
        switch (week) {
            case (1):
                mWeek=7;
                break;
            case (2):
                mWeek=1;
                break;
            case 3:
                mWeek=2;
                break;
            case 4:
                mWeek=3;
                break;
            case 5:
                mWeek=4;
                break;
            case 6:
                mWeek=5;
                break;
            case 7:
                mWeek=6;
                break;
        }
        return mWeek;
    }
}
