package com.cqc.demo.controller;


import com.cqc.demo.DemoApplication;
import com.cqc.demo.db.entity.secondary.User;
import com.cqc.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/test")
    public String getHi() {
        StringBuilder stringBuilder = new StringBuilder();
        return "Hello";
    }

    @GetMapping("/getUser")
    public List<User> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/saveUser")
    public void saveUser() {
        com.cqc.demo.db.entity.primary.User user = new com.cqc.demo.db.entity.primary.User();
        user.setUsername("LOO");
        user.setPassword("Kona");
        userService.saveUser(user);
    }

}
