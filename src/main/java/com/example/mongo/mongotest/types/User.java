package com.example.mongo.mongotest.types;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public List<String> hobbies;
    public List<User> friends;

    public User(String firstName, String lastName, List<String> hobbies, List<User> friends) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
        this.friends = friends;
    }
}
