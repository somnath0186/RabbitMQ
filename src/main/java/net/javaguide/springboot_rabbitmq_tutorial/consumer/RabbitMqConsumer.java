package net.javaguide.springboot_rabbitmq_tutorial.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    private  static final Logger LOGGER=LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info("received message in consumer -> %s",message);
        LOGGER.info(String.format("received message in consumer -> %s",message));

    }

}
