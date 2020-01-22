package com.baizhiedu.service;

import com.baizhiedu.dao.OrderDAO;
import com.baizhiedu.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements  OrderService {


    @Autowired
    private OrderDAO orderDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Order> findAll(String id) {
        return orderDAO.findAll(id) ;
    }
}
