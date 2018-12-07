package com.peihou.dao;

import com.peihou.pojo.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    boolean insert(Orders orders);
    boolean update(Orders orders);
    Orders findOrderById(int id);
    List<Orders> findUserOrdersById(int uid);
    Orders findOrderByCodes(String codes);
}
