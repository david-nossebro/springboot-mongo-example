package com.example.mongo.mongotest.controllers;

import com.example.mongo.mongotest.repositories.UserRepository;
import com.example.mongo.mongotest.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id:.+}")
    public User get(@PathVariable("id") String id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/")
    public List<User> get() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User post(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id:.+}")
    public User put(@PathVariable("id") String id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id:.+}")
    public void delete(@PathVariable("id") String id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody User user) {
        userRepository.delete(user);
    }
}
