package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(String name){
        //第一种方式调用
        //RestTemplate restTemplate = new RestTemplate();
        //参数1:调用url  参数2:响应数据类型
        //String forObject = restTemplate.getForObject("http://localhost:9090/hello/sayHello?name=" + name, String.class);
        //System.out.println(forObject);

        //第二种调用方式
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("SERVICE-CLIENT");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String forObject = restTemplate.getForObject("http://" + host + ":" + port + "/hello/sayHello?name=" + name, String.class);
        System.out.println(forObject);*/

        //第三种方式
        String forObject = restTemplate.getForObject("http://SERVICE-CLIENT/hello/sayHello?name=" + name, String.class);
        System.out.println(forObject);


        return forObject;
        
    }
}
