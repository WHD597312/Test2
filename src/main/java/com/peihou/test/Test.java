package com.peihou.test;

import com.alibaba.fastjson.JSON;
import com.peihou.pojo.Orders;
import com.peihou.pojo.Person;
import com.peihou.pojo.User;
import com.peihou.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.InetAddress;
import java.util.*;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        Person person2= (Person) ac.getBean("person2");
//        System.out.println(person2);
        UserService userService = (UserService) ac.getBean("userService");
        User user = userService.selectUserOrdersById2(2);
        List<Orders> orders = user.getOrdersList();
        for (Orders orders1 : orders) {
            System.out.println(orders1);
        }
//        System.out.println(user);
    }

    @org.junit.Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Person person3 = (Person) ac.getBean("person3");
        System.out.println(person3);
    }

    @org.junit.Test
    public void getUUID() {
//        String uuid=UUID.randomUUID().toString();
//        uuid=uuid.replaceAll("-","");
//        System.out.println(uuid);
//        Random random=new Random();
//        int x=random.nextInt(10);
//        System.out.println("size:"+uuid.length());
//        System.out.println("x="+x);
        try {
            String s = "{\"Warmer\":[144,1,1,238,40,252,1,0,127,0,0,0,0,0,0, 0,0, 0,0,0, 0,0,0,0,0,30,19,20, 21,25, 10,25,0,0,0,0,0,0,33,9]}";
            System.out.println(s);
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("Warmer");
            int sum = 0;
            for (int i = 0; i < 38; i++) {
                sum = sum + jsonArray.getInt(i);
            }
            int check = sum % 256;
            jsonArray.put(38, check);
            System.out.println(jsonArray);
            jsonObject.put("Warmer", jsonArray);
            System.out.println(jsonObject);
            int x = 76;
            int y = 30;
            int x2 = (x * y) / 40;
            System.out.println("x2==" + x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test4() {
        try {
            Calendar calendar = Calendar.getInstance();
            int headCode = 85;
            int effectTime = 1;
            int year = calendar.get(Calendar.YEAR);
            int yearHigh = year / 256;
            int yearLow = year % 256;
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            week = getWeek(week);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            int funCode = 2;
            int sum = headCode + effectTime + yearHigh + yearLow + month + day + week + hour + min + second + funCode;
            int checkCode = sum % 256;
            int endCode = 136;
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(0, headCode);
            jsonArray.put(1, effectTime);
            jsonArray.put(2, yearHigh);
            jsonArray.put(3, yearLow);
            jsonArray.put(4, month);
            jsonArray.put(5, day);
            jsonArray.put(6, week);
            jsonArray.put(7, hour);
            jsonArray.put(8, min);
            jsonArray.put(9, second);
            jsonArray.put(10, funCode);
            jsonArray.put(11, checkCode);
            jsonArray.put(12, endCode);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Warmer", jsonArray);
            String s = jsonObject.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test5() {
        try {
            String s = "{\n" +
                    "\t\"Warmer\": [60, 0, 2, 68, 16, 17, 31, 255, 7, 129, 255, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 1, 2, 3, 4, 30, 156, 154, 149, 0, 0, 0, 99, 70]\n" +
                    "}";

            JSONObject jsonObject = new JSONObject(s);
            System.out.println(s);
//            JSONArray jsonArray=new JSONArray(jsonObject);
            JSONArray jsonArray = jsonObject.getJSONArray("Warmer");
            int sum = 0;
            for (int i = 0; i < jsonArray.length() - 2; i++) {
                sum = sum + jsonArray.getInt(i);
            }
            sum = sum % 256;
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 得到某一天的星期几
     *
     * @return
     */
    public int getWeek(int week) {
        int mWeek = 0;
        switch (week) {
            case (1):
                mWeek = 7;
                break;
            case (2):
                mWeek = 1;
                break;
            case 3:
                mWeek = 2;
                break;
            case 4:
                mWeek = 3;
                break;
            case 5:
                mWeek = 4;
                break;
            case 6:
                mWeek = 5;
                break;
            case 7:
                mWeek = 6;
                break;
        }
        return mWeek;
    }

    @org.junit.Test
    public void test6() {
        int x = 10;
        int y = x >> 2 & 1;
        int[] u = {0, 1, 0, 0, 0, 0, 1, 1};
        int c = sum(u);
        System.out.println(c);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("java", 1);
        map.put("android", 2);
        map.put("ios", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key=" + key + ",value=" + value);
        }

        String sss = "p99/wPurifier1";
        System.out.println("len=" + sss.length());
    }

    public int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += x[i] << (7 - i);
        }
        return sum;
    }

    @org.junit.Test
    public void test7() {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(0, 60);
            jsonArray.put(1, 1);
            jsonArray.put(2, 2);
            jsonArray.put(3, 33);
            jsonArray.put(4, 67);
            jsonArray.put(5, 10);
            jsonArray.put(6, 20);
            jsonArray.put(7, 30);
            jsonArray.put(8, 40);
            jsonArray.put(9, 50);
            jsonArray.put(10, 10);
            jsonArray.put(11, 11);
            jsonArray.put(12, 12);
            jsonArray.put(13, 13);
            jsonArray.put(14, 14);
            jsonArray.put(15, 15);
            jsonArray.put(16, 16);
            jsonArray.put(17, 17);
            jsonArray.put(18, 18);
            jsonArray.put(19, 19);
            jsonArray.put(20, 20);
            jsonArray.put(21, 21);
            jsonArray.put(22, 22);
            jsonArray.put(23, 23);
            jsonArray.put(24, 24);
            jsonArray.put(25, 25);
            jsonArray.put(26, 26);
            jsonArray.put(27, 27);
            jsonArray.put(28, 28);
            jsonArray.put(29, 29);
            jsonArray.put(30, 30);
            jsonArray.put(31, 31);
            jsonArray.put(32, 32);
            jsonArray.put(33, 33);
            jsonArray.put(34, 34);
            jsonArray.put(35, 35);
            jsonArray.put(36, 36);
            jsonArray.put(37, 37);
            int sum = 0;
            for (int i = 0; i < 38; i++) {
                sum += jsonArray.getInt(i);
            }
            int checkCode = sum % 256;
            jsonArray.put(38, checkCode);
            jsonArray.put(39, 70);

            jsonObject.put("WPurifier", jsonArray);

            System.out.println("len=" + jsonArray.length());
            System.out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test8() {
//        private int id;
//        private String name;
//        private int age;
//        private String sex;
//        private String address;
//        private String phone;
//        private String email;
//        private String codes;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("name", "王海东");
        jsonObject.put("age", 26);
        jsonObject.put("sex", "男");
        jsonObject.put("address", "天水市");
        jsonObject.put("phone", "123456");
        jsonObject.put("email", "1352250152");

        Student student = JSON.parseObject(jsonObject.toString(), Student.class);
        System.out.println(student);
    }

    @org.junit.Test
    public void test9() throws Exception {
        double a = 1111*10;
        int b= (int) a;
        String range=Integer.toHexString(b);

//        String middlePower="";
//        String lowPower="";
//        String highPower="";
//        String range=Integer.toHexString(rangeValue);
//        String range=Integer.toHexString(rangeValue);
        if (range.length()==1){
            range="00000"+range;
        }else if (range.length()==2){
            range="0000"+range;
        }else if (range.length()==3){
            range="000"+range;
        }else if (range.length()==4){
            range="00"+range;
        }else if (range.length()==5) {
            range="0"+range;
        }
        int middlePower=0;
        int lowPower=0;
        int highPower=0;
        highPower=Integer.parseInt(range.substring(0,2),16);
        middlePower=Integer.parseInt(range.substring(2,4),16);
        lowPower=Integer.parseInt(range.substring(4),16);


        String middlePower2="";
        String lowPower2="";
        String highPower2="";
        highPower2=Integer.toHexString(highPower);
        if (highPower2.length()==0){
            highPower2="00";
        } else if (highPower2.length()==1){
            highPower2="0"+highPower2;
        }
        middlePower2=Integer.toHexString(middlePower);

        if (middlePower2.length()==0){
            middlePower2="00";
        } else if (middlePower2.length()==1){
            middlePower2="0"+middlePower2;
        }

        lowPower2=Integer.toHexString(lowPower);
        if (lowPower2.length()==0){
            lowPower2="00";
        } else if (lowPower2.length()==1){
            lowPower2="0"+lowPower2;
        }
        String sss=highPower2+middlePower2+lowPower2;
        int hhh=Integer.parseInt(sss,16);
        System.out.println(hhh+",length="+range.length());
    }

    StringBuffer sb=new StringBuffer();
    public String strTo16(String str) {
        sb.setLength(0);
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            String s2 = Integer.toHexString(Integer.parseInt(s[i])).toUpperCase();
            sb.append(s2);
        }
        return sb.toString();
    }
    @org.junit.Test
    public void test10() {
        int[] x = {0, 0, 0, 0, 0, 0, 1, 1};
        int x2 = changeToTen(x);
        String ss = " 17:13:8B:F7:74:0C:8E:EC:75:A1:BC:57:7D:E6:F1:BB";
        System.out.println(ss.length());
        int x4 = (-19 + 100) * 10 / 256;
        int x5 = (-19 + 100) * 10 % 256;
        double x6 = ((0x04 * 256) + 0xA6) / 10 - 100;
        System.out.println("-----" + x6);
        System.out.println("-->" + x4 + "," + x5);


        byte[] bytes = new byte[61];
        bytes[0] = 0x3c;
        bytes[1] = 0x11;
        bytes[2] = 0x01;
        bytes[3] = 0x37;
        bytes[4] = 0x00;
        bytes[5] = (byte) 0xF0;
        bytes[8] = 0x40;
        bytes[44] = 0x32;
        bytes[45] = 0x32;
        bytes[46] = 0x46;
        bytes[47] = 0x32;
        bytes[48] = 0x46;
        bytes[49] = 0x32;
        bytes[50] = 0x46;
        bytes[51] = 0x32;
        bytes[52] = 0x46;
        bytes[53] = 0x32;
        bytes[54] = 0x01;
        bytes[55] = 0x02;
        bytes[56] = 0x03;
        bytes[57] = 0x04;
        bytes[59] = 0x03;
        bytes[60] = 0x46;
    }

    public static String encryptBASE64(String str) {
        byte[] key = str.getBytes();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String strs = base64Encoder.encodeBuffer(key);
        return strs;
    }


    public int[] changeToTwo(int x) {

        int[] result = new int[8];
        result[0] = x / 128;
        result[1] = (x % 128) / 64;
        result[2] = (x % 64) / 32;
        result[3] = (x % 32) / 16;
        result[4] = (x % 16) / 8;
        result[5] = (x % 8) / 4;
        result[6] = (x % 4) / 2;
        result[7] = (x % 2) / 1;
        return result;
    }

    public int changeToTen(int[] x) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result += x[i] << (i);
        }
        return result;
    }

    @org.junit.Test
    public void test12(){
        int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };
        int index=binarySort(arr,56);
        System.out.println("index="+index);

        Student student=new Student(1,"1","231031090111");
        Student student4=new Student(4,"4","231031090114");
        Student student3=new Student(3,"3","231031090113");
        Student student5=new Student(5,"5","231031090115");
        Student student2=new Student(2,"2","231031090112");
        Student student6=new Student(6,"6","231031090116");
        List<Student> students=new ArrayList<>();

        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        for (int i = 0; i <students.size() ; i++) {
            Student s=students.get(i);
            System.out.println(s);
        }
        Student student0=new Student(5,"2222222","231031090115");
        int index2=Collections.binarySearch(students,student0 , new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId()>o2.getId()){
                    return 1;
                }else if (o1.getId()<o2.getId()){
                    return -1;
                }
                return 0;
            }
        });

        System.out.println("students:"+index2);
        students.set(index2,student0);
        for (int i = 0; i <students.size() ; i++) {
            Student s=students.get(i);
            System.out.println(s);
        }
    }
    private int  binarySort(int[] arr,int key){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int middle=(start+end)/2;
            if (key<arr[middle]){
                end=middle-1;
            }else if (key>arr[middle]){
                start=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
