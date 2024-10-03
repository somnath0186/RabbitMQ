package net.javaguide.springboot_rabbitmq_tutorial.publisher;

import net.javaguide.springboot_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {

    private static Logger LOGGER= LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent -> %s ",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,user);

    };


}
