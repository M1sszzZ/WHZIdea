package com.baizhiedu.controller;

import com.baizhiedu.entity.Order;
import com.baizhiedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @RequestMapping("/findAll")
    public List<Order> findAll(String userid){
        System.out.println("用户id: "+userid);
      /*  try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return orderService.findAll(userid);
    }

}
