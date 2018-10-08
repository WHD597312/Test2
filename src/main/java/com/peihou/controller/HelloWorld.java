package com.peihou.controller;

import com.peihou.pojo.Student;
import com.peihou.service.StudentService;
import com.peihou.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloWorld {

    @Resource
    StudentService studentService;
   @RequestMapping("/hello")
    public @ResponseBody String hello(){
        return "hello";
    }
    @RequestMapping("hello2")
    public String hello2(){
       return "hello2";
    }

    @RequestMapping(value = "/getStudentName",method = RequestMethod.GET)
    public @ResponseBody
    Student getStudentName(@RequestParam int id){
       return studentService.getStudentName(id);
    }
}
