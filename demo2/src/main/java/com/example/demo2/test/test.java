package com.example.demo2.test;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/6/24 15:26
 */
@Configuration
public class test {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("queue") Queue queueMessage, DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

}
