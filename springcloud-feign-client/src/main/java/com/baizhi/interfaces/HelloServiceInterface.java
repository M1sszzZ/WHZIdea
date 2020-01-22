package com.baizhi.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-client")
public interface HelloServiceInterface {


    @RequestMapping("/hello/sayHello")
    public String sayHello(@RequestParam("name") String name);

}
