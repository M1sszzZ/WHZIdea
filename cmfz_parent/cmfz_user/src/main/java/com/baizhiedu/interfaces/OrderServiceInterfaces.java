package com.baizhiedu.interfaces;

import com.baizhiedu.entity.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ORDER",fallback = OrderServiceInterfaceImpl.class)
public interface OrderServiceInterfaces {

    @RequestMapping("/order/findAll")
    public List<Order> findAll(@RequestParam("userid") String aa);


}
