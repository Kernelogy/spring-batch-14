package com.edex.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        User savedObject = userRepo.saveAndFlush(user);//Insert 

        return savedObject;

    }

    @GetMapping("/list")
    public List<User> listUsers(){
        List<User> users = userRepo.findAll();//Select
        return users;
    }

    @GetMapping("/get/{val}")
    public User getUser(@PathVariable int val){
        User user = userRepo.findById(val).get();
        return user;
    }

    // public List<User> findByUsername(String username);

    @GetMapping("/getByUsername/{username}")
    public List<User> getUserByUsername(@PathVariable String username){
        List<User> users = userRepo.findByUsername(username);
        return users;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        userRepo.deleteById(id);
        return "Success";
    }


}
