package com.youcash;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package: com.youcash
 * @FileName: Consumer
 * @Desc:
 * @Author: Wanghezi
 * @CreateTime: 2019-12-11 17:19
 */
@Component
@Slf4j
public class Consumer {
    private final Logger logger =  LoggerFactory.getLogger(Producer.class);
    @KafkaListener(topics = "test1",groupId = "consumer1")
    public void consumer(ConsumerRecord<String,String> record){
        for (int i = 0; i < 10; i++) {
            logger.info("topic-->"+record.topic()+" offset-->"+record.offset()+" value-->"+record.value());
        }
    }
}
