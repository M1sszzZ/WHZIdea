package com.baizhi.interfaces;

import com.baizhi.entity.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("ORDER-SERVICE")
public interface OrderServiceInterface {


    @RequestMapping("/order/findById")
    public List<Order> find(@RequestParam("id") String id);

    @RequestMapping("/order/save")
    public void save(@RequestBody  Order order);

}
