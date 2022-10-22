package com.boshen.seckill.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver {
    @RabbitListener(queues = "queue")
    public void receive(Object msg){
        log.info("接收消息 "+msg);
    }

    @RabbitListener(queues = "queue_fanout01")
    public void receive1(Object msg){
        log.info("接收消息 "+msg);
    }

    @RabbitListener(queues = "QUEUE_DIRECT01")
    public void receive2(Object msg){
        log.info("接收消息queue01 "+msg);
    }

    @RabbitListener(queues = "QUEUE_DIRECT02")
    public void receive3(Object msg){
        log.info("接收消息queue02 "+msg);
    }

}
