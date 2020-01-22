package com.baizhi.controller;

import com.baizhi.entity.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    //根据用户id查询所有订单
    @RequestMapping("/findById")
    public List<Order> findOrderById(String id){
        System.out.println("用户id: "+id);
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order("1","超短裙"));
        orders.add(new Order("2","超短连衣裙"));
        orders.add(new Order("3","蕾丝超短裙"));
        return orders;
    }

    //生成order订单
    @RequestMapping("/save")
    public void save(@RequestBody  Order order){
        System.out.println("生成订单: "+order);
        System.out.println("订单id: "+order.getId());
        System.out.println("订单名称: "+order.getName());
    }

}
