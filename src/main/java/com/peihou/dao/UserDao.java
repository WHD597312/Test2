package com.peihou.dao;

import com.peihou.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public boolean insert(User user);
    public boolean update(User user);
    public User findUserById(int id);
    public User findUserByCodes(String codes);
    public User selectUserOrdersById1(int uid);
    public User selectUserOrdersById2(int uid);
}
