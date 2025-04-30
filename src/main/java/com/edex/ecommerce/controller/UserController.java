package com.edex.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.ecommerce.dto.request.LoginData;
import com.edex.ecommerce.dto.response.LoginResponse;
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
    @PostMapping("/insert")
    public String insertUser(@RequestBody User dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setContact(dto.getContact());
        userRepo.saveAndFlush(user);
        return "User Created Successfully";
    }

    @GetMapping("/list")
    public List<User> listUsers(){
        List<User> users = userRepo.findAll();//Select
        return users;
    }

    @GetMapping("/get/{val}")
    public User getUser(@PathVariable int val){
        // User user = userRepo.findById(val).get();
        User user = userRepo.findByUserId(val);
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

    // public User findByUsernameAndPassword(String username, String password);
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginData dto){
        User user = userRepo.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        /*
        if(user == null){
            return "Failed";
        }else{
            return "Success";
        }
        */

        LoginResponse res = new LoginResponse();
        if(user == null){
            res.setStatus(false);
            res.setMessage("Login Failed");
        }else{
            res.setStatus(true);
            res.setMessage("Login Success");
        }
        return ResponseEntity.ok().body(res);

    }
    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User dto){
        User user = userRepo.findById(dto.getId()).get();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setContact(dto.getContact());
        userRepo.saveAndFlush(user);
        return ResponseEntity.ok().body("User Updated Successfully");
    }


}


/*
select * from users => findAll
select * from users where id = 1 // findById
select * from users where username = 'mukilan' // findByUsername

delete  from users where id = 1 // deleteById

insert into users(id, username, password, email, contact) values(1, 'mukilan', '12345', 'mukilan@gmail.com', '9876543210') 



 */
