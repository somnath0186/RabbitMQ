package net.javaguide.springboot_rabbitmq_tutorial.config;


import net.javaguide.springboot_rabbitmq_tutorial.controller.MessageController;
import org.springframework.amqp.core.*;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    public String queue;

    @Value("${rabbitmq.queue.json.name}")
    public String json_queue;
    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Value("${rabbitmq.routing.key}")
    public String routingKey;
    @Value("${rabbitmq.routing.json.key}")
    public String jsonRoutingKey;
    //spring bean for rabbitmq queue
    @Bean
    public Queue queue(){

        return new Queue(queue);
    }
    //spring to stored json bean
    @Bean
    public Queue jsonOueue(){

        return new Queue(json_queue);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    //binding queue and echange by routing key

    @Bean
    public Binding bindingBuilder(){
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
    }

    //binding between queue and exchange using routing key


    //
    @Bean
    public Binding jsonDataBinding(){
        return BindingBuilder.bind(jsonOueue()).to(exchange()).with(jsonRoutingKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }


    //Spring bean automatically configure following Rabbit mq classes ,so we can directly inject then and use.
     //ConnectionFactory
    //RabbitTemplate
    //Rabbit Admin

}
