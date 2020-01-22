package com.baizhiedu.service;

import com.baizhiedu.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAll(String id);
}
