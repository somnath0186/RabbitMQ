package net.javaguide.springboot_rabbitmq_tutorial.dto;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
