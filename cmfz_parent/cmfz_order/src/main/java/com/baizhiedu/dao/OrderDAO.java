package com.baizhiedu.dao;

import com.baizhiedu.entity.Order;

import java.util.List;

public interface OrderDAO {

    public List<Order> findAll(String userId);


}
