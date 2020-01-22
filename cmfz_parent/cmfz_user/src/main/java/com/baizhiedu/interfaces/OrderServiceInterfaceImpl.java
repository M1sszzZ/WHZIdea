package com.baizhiedu.interfaces;

import com.baizhiedu.entity.Order;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class OrderServiceInterfaceImpl implements OrderServiceInterfaces {

    @Override
    public List<Order> findAll(String aa) {
        System.out.println("出现故障.....");
        Order order = new Order("1", "出现故障", new Date());
        return Arrays.asList(order);
    }
}
