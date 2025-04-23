package com.edex.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.ecommerce.model.User;
import com.edex.ecommerce.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/insert")
    public User insert(){
        
        User user = new User();
        user.setUsername("mukilan");
        user.setPassword("12345");
        user.setEmail("mukilan@example.com");
        user.setContact("9876543210");

        User savedObject = userRepo.saveAndFlush(user);

        return savedObject;

    }

}
