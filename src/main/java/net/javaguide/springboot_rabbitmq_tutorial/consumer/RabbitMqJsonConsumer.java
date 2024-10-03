package net.javaguide.springboot_rabbitmq_tutorial.consumer;


import net.javaguide.springboot_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonConsumer {
    private  static final Logger LOGGER= LoggerFactory.getLogger(RabbitMqJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user){
        LOGGER.info("received message in consumer -> %s",user);
        LOGGER.info(String.format("received message in consumer -> %s",user));

    }
}
