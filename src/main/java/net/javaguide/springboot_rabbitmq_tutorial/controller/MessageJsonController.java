package net.javaguide.springboot_rabbitmq_tutorial.controller;


import net.javaguide.springboot_rabbitmq_tutorial.dto.User;
import net.javaguide.springboot_rabbitmq_tutorial.publisher.RabbitMqJsonProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbit/v1")
public class MessageJsonController {

    private RabbitMqJsonProducer rabbitMqJsonProducer;
    public MessageJsonController(RabbitMqJsonProducer rabbitMqJsonProducer) {
        this.rabbitMqJsonProducer = rabbitMqJsonProducer;
    }


    @PostMapping("/publish")
   public ResponseEntity<?> sendJsonMessage(@RequestBody User user){
        rabbitMqJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>("message send succesfully", HttpStatus.OK);
   }



}
