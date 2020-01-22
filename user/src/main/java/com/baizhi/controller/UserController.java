package com.baizhi.controller;

import com.baizhi.entity.Order;
import com.baizhi.interfaces.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private OrderServiceInterface orderServiceInterface;

    @RequestMapping("/find")
    public List<Order> find(String id){
        System.out.println("用户user id: "+id);
        List<Order> orders = orderServiceInterface.find(id);
        return orders;
    }

    @RequestMapping("/save")
    public String save(){
        Order order = new Order();
        order.setId("222");
        order.setName("超短蕾丝连衣裙");
        orderServiceInterface.save(order);
        return "ok";
    }
}
