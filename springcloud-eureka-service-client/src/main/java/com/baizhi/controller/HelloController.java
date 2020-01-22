package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        System.out.println("姓名:　"+name);
        return "server0: hello " + name;
    }

}
