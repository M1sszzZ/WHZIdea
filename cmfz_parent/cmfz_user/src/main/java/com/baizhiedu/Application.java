package com.baizhiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;



@EnableFeignClients
@SpringCloudApplication // @EnableDiscoveryClient @SpringBootApplication @EnableCircuitBreaker
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
