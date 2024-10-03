package net.javaguide.springboot_rabbitmq_tutorial.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Value("${rabbitmq.routing.key}")
    public String routingKey;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMqProducer.class);

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private RabbitTemplate rabbitTemplate;

public void sendMessage(String message){
    LOGGER.info(String.format("message send -> %s",message));
    rabbitTemplate.convertAndSend(exchange,routingKey,message);
 
}



}
