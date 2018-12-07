package com.peihou.controller;

import com.peihou.dao.UserDao;
import com.peihou.pojo.User;
import com.peihou.service.UserService;
import com.peihou.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired UserService userService;
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public @ResponseBody String hello(){
        return "hello";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody Messages insert(@RequestBody User user){
        Messages messages=new Messages();
        if (user!=null){
            String codes=UUID.randomUUID().toString().replaceAll("-","");
            user.setCodes(codes);
        }
        boolean success=userService.insert(user);
        if (success){
            messages.setCode(2000);
            messages.setMsg("添加成功");
            user=userService.findUserByCodes(user.getCodes());
            messages.setContent(user);
        }
        return messages;
    }
//    @RequestMapping(value = "/findUserByCodes",method = RequestMethod.GET)
//    public @ResponseBody Messages findUserByCodes(@RequestParam int id){
//        User user=userService.findUserById(id);
//        Messages messages=new Messages();
//        if (user!=null){
//            messages.setCode(2000);
//            messages.setMsg("查询成功");
//            messages.setContent(user);
//        }else {
//            messages.setCode(-2000);
//            messages.setMsg("该用户不存在");
//        }
//        return messages;
//    }
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public @ResponseBody Messages findUserById(@RequestParam int id2){
        User user=userService.findUserById(id2);
        Messages messages=new Messages();
        if (user!=null){
            messages.setCode(2000);
            messages.setMsg("查询成功");
            messages.setContent(user);
        }else {
            messages.setCode(-2000);
            messages.setMsg("该用户不存在");
        }
        return messages;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public @ResponseBody Messages updateUser(@RequestBody User user){
        Messages messages=new Messages();
        if (user!=null){
            User user2=userService.findUserById(user.getUid());
            if (user2!=null){
                boolean success=userService.update(user);
                if (success){
                    messages.setCode(2000);
                    messages.setMsg("更新成功");
                    messages.setContent(user);
                }else {
                    messages.setCode(-2000);
                    messages.setMsg("更新失败");
                }
            }else {
                messages.setCode(-2001);
                messages.setMsg("该用户不存在");
            }
        }else {
            messages.setCode(-2002);
            messages.setMsg("错误的请求参数");
        }
        return messages;
    }
    @RequestMapping(value = "/fileLoad/user/{userId}",method = RequestMethod.POST)
    public @ResponseBody Messages fileLoad(@RequestParam("file") MultipartFile file,@PathVariable("userId") int useId, HttpServletRequest request){
        Messages msg=new Messages();
        if (!file.isEmpty()){
//            String contextPath=request.getContextPath();
//            String servletPath=request.getServletPath();
//            String scheme=request.getScheme();

            String basePath=request.getServletContext().getRealPath("/user/images/");
//            String storePath= "E:\\project\\SpringMvcFileUpload\\WebRoot\\images";//存放我们上传的文件路径
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date(System.currentTimeMillis());
            String fileName = format.format(date)+".jpg";
            File filePath=new File(basePath,fileName);
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            try {
                File imageFile=new File(basePath+fileName);
                file.transferTo(imageFile);
                User user=userService.findUserById(useId);
                if (user!=null){
                    String sss=imageFile.getPath();
                    System.out.println(sss);
                    user.setImage(fileName);
                    userService.update(user);
                }
            }catch (Exception e){
                e.printStackTrace();
                msg.setCode(-2000);
                msg.setMsg("上传失败");
            }
            msg.setCode(2000);
            msg.setMsg("上传成功");
        }else {
            msg.setCode(-2001);
            msg.setMsg("错误的请求参数");
        }
        return msg;
    }

    @RequestMapping(value = "/fileDown",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<byte[]> fileDown(@RequestParam("id") int id,HttpServletRequest request) throws Exception{
        User user=userService.findUserById(id);
        HttpHeaders headers=new HttpHeaders();
        if (user!=null){
            String image=user.getImage();
            String imagePath=request.getServletContext().getRealPath("/user/images/")+image;
            File file=new File(imagePath);
            if (file.exists()){
                InputStream inputStream=new FileInputStream(file);
                byte[] body=new byte[inputStream.available()];
                inputStream.read(body);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment",file.getName());
                HttpStatus status=HttpStatus.CREATED;
                return new ResponseEntity<byte[]>(body,headers,status);
            }
        }
        byte[] body=new byte[0];
        return  new ResponseEntity<byte[]>(body,headers,HttpStatus.BAD_REQUEST);
    }
}
