package com.peihou.service;

import com.peihou.dao.UserDao;
import com.peihou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public boolean insert(User user){
        return userDao.insert(user);
    }
    public boolean update(User user){
        return userDao.update(user);
    }
    public User findUserById(int id){
        return userDao.findUserById(id);
    }
    public User findUserByCodes(String codes){
        return userDao.findUserByCodes(codes);
    }
    public User selectUserOrdersById1(int uid){
        return userDao.selectUserOrdersById1(uid);
    }

    public User selectUserOrdersById2(int uid){
        return userDao.selectUserOrdersById2(uid);
    }


}
