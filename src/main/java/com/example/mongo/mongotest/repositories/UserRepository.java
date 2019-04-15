package com.example.mongo.mongotest.repositories;

import com.example.mongo.mongotest.types.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByFirstName(String name);
    public List<User> findByLastName(String name);
}
