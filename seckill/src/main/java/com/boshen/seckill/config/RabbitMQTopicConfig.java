package com.boshen.seckill.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {
    private static final String QUEUE01="queue_topic01";
    private static final String QUEUE02="queue_topic02";
    private static final String EXCHANGE="topicExchange";
    private static final String ROUTINGKEY01="#.queue.#";
    private static final String ROUTINGKEY02="*.queue.#";

    @Bean
    public Queue queue05(){
        return new Queue(QUEUE01);
    }
    @Bean
    public Queue queue06(){
        return new Queue(QUEUE02);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding05(){
        return BindingBuilder.bind(queue05()).to(topicExchange()).with(ROUTINGKEY01);
    }

    @Bean
    public Binding binding06(){
        return BindingBuilder.bind(queue06()).to(topicExchange()).with(ROUTINGKEY02);
    }
}
