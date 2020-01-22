package com.baizhiedu.controller;

import com.baizhiedu.entity.Order;
import com.baizhiedu.entity.User;
import com.baizhiedu.interfaces.OrderServiceInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderServiceInterfaces orderServiceInterfaces;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = new ArrayList<User>();
        users.add(new User("21","小黑",23));
        users.add(new User("23","小三",23));
        return users;
    }

    @RequestMapping("/findOrders")
    /*@HystrixCommand(fallbackMethod = "error",
        commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
        }
    )*/
    public List<Order> findOrders(String userid){
        //String forObject = restTemplate.getForObject("http://ORDER/order/findAll?userid="+userid, String.class);
        //List<Order> orders = JSONObject.parseArray(forObject, Order.class);
        //List<Order> orders = JSONObject.parseArray(forObject, Order.class);*/
       return orderServiceInterfaces.findAll(userid);
        //throw new  RuntimeException("xxxx");
    }

   /* public String error(String userid){
        System.out.println(userid);
        return "服务器太拥挤,拥挤死了吧~~~";
    }*/

}
