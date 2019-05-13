package com.peihou.controller;

import com.peihou.pojo.Student;
import com.peihou.service.StudentService;
import com.peihou.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
public class HelloWorld {

    @Resource
    StudentService studentService;
   @RequestMapping("/hello")
    public @ResponseBody String hello(){
       System.out.println("处理客户端请求");
        return "hello";
    }
    @RequestMapping("hello2")
    public String hello2(){
       System.out.println("--->"+"sssssssssssssssssss");
       return "hello2";
    }

    @RequestMapping("/insert")
    public @ResponseBody Messages insert(Student student){
        Messages messages=new Messages();
        if (student!=null){
            String codes=UUID.randomUUID().toString().replaceAll("-","");
            student.setCodes(codes);
        }
        boolean success=studentService.insert(student);
        if (success){
            messages.setCode(2000);
            messages.setMsg("添加成功");
            student=studentService.getStudentByCodes(student.getCodes());
            messages.setContent(student);
        }else {
            messages.setCode(-2000);
            messages.setMsg("添加失败");
            messages.setContent(null);
        }
        return messages;
    }
    @RequestMapping("/deleteById")
    public @ResponseBody Messages deleteById(int id){
       Messages messages=new Messages();
        boolean success=studentService.delete(id);
        if (success){
            messages.setCode(2000);
            messages.setMsg("删除成功");
            messages.setContent(null);
        }else {
            messages.setCode(-2000);
            messages.setMsg("删除失败");
            messages.setContent(null);
        }
        return messages;
    }
    @RequestMapping(value = "/getStudentById",method = RequestMethod.GET)
    public @ResponseBody
    Messages getStudentById(@RequestParam int id){
       Messages messages=new Messages();
       Student student=studentService.getStudentById(id);
       if (student!=null){
           messages.setCode(2000);
           messages.setMsg("查询成功");
           messages.setContent(student);
       }else {
           messages.setCode(-2000);
           messages.setMsg("查询失败");
           messages.setContent(student);
       }
       return messages;
    }
    @RequestMapping(value = "/updateById",method = RequestMethod.GET)
    public @ResponseBody Messages  updateById(Student student){
        Messages messages=new Messages();
       boolean flag=studentService.updateById(student);
       if (flag){
           messages.setCode(2000);
           messages.setMsg("更新成功");
           Student student2=studentService.getStudentById(student.getId());
           messages.setContent(student2);
       }else {
           messages.setCode(-2000);
           messages.setMsg("更新失败");
           messages.setContent(null);
       }
        return messages;
    }
    @RequestMapping("/findAllStudent")
    public @ResponseBody Messages findAllStudent(){
       Messages messages=new Messages();
       List<Student> students=studentService.findAllStudent();
       if (students==null){
           messages.setCode(-2000);
           messages.setMsg("查询失败");
           messages.setContent(null);
       }else {
           messages.setCode(2000);
           messages.setMsg("查询成功");
           messages.setContent(students);
       }
       return messages;
    }
}
