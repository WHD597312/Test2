package com.peihou.controller;

import com.peihou.dao.OrderDao;
import com.peihou.pojo.Orders;
import com.peihou.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired OrderDao orderDao;
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody Messages insert(@RequestBody Orders orders){
        Messages msg=new Messages();
        if (orders!=null){
            String codes=UUID.randomUUID().toString().replaceAll("-","");
            orders.setCodes(codes);
            boolean success=orderDao.insert(orders);
            if (success){
                orders=orderDao.findOrderByCodes(codes);
                msg.setCode(2000);
                msg.setMsg("创建成功");
                msg.setContent(orders);
            }else {
                msg.setCode(-2000);
                msg.setMsg("创建失败");
            }
        }else {
            msg.setMsg("错误的请求参数");
            msg.setCode(-2001);
        }
        return msg;
    }

}
