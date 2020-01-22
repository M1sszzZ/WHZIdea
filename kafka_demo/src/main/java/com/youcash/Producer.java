package com.youcash;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: com.youcash
 * @FileName: Producer
 * @Desc:
 * @Author: Wanghezi
 * @CreateTime: 2019-12-11 17:14
 */
@Controller
@Slf4j
@RequestMapping("kafka")
public class Producer {
   private final Logger logger =  LoggerFactory.getLogger(Producer.class);
   @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

   @RequestMapping("send")
   public void send(String msg){
       ListenableFuture<SendResult<String, String>> sendResultListenableFuture = kafkaTemplate.send("test1", msg);
       sendResultListenableFuture.addCallback(
               success -> logger.info("生产者发送成功"),
               fail -> logger.info("生产者发送失败")
       );
   }
}
