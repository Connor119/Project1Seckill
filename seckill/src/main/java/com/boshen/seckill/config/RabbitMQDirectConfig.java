package com.boshen.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    private static final String QUEUE03="QUEUE_DIRECT01";
    private static final String QUEUE04="QUEUE_DIRECT02";
    private static final String EXCHANGE="directExchange";
    private static final String ROUTINGKEY01="queue.red";
    private static final String ROUTINGKEY02="queue.green";

    @Bean
    public Queue queue03(){
        return new Queue(QUEUE03);
    }
    @Bean
    public Queue queue04(){
        return new Queue(QUEUE04);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding03(){
        return BindingBuilder.bind(queue03()).to(directExchange()).with(ROUTINGKEY01);
    }

    @Bean
    public Binding binding04(){
        return BindingBuilder.bind(queue04()).to(directExchange()).with(ROUTINGKEY02);
    }

}
