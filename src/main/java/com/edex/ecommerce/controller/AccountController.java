package com.edex.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edex.ecommerce.dto.request.LoginData;
import com.edex.ecommerce.dto.response.Student;

@RestController
public class AccountController {
// http://localhost:8080/login?username=admin&password=12345
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        // System.out.println(username + " " + password);
        // return "Login Success";
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")){
            return "Login Sucess";
        }else{
            return "Login Failed";
        }
    }
    @PostMapping("/login")
    public String postLogin(@RequestBody LoginData data){
        String username = data.getUsername();
        String password = data.getPassword();
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")){
            return "Login Sucess";
        }else{
            return "Login Failed";
        }
    }
    /*
    @GetMapping("/student/get")
    public Student getStudent(){
        Student s = new Student();
        s.setFirstName("Karumukilan");
        s.setLastName("Subbiah");
        s.setDepartment("Physics");
        return s;
    }
    */
    @GetMapping("/student/get")
    public ResponseEntity<Student> getStudent(){
        Student s = new Student();
        s.setFirstName("Karumukilan");
        s.setLastName("Subbiah");
        s.setDepartment("Physics");
        return ResponseEntity
        .ok()
        .header("edex-header-1", "Welcome to Edex")
        .header("edex-header-2", "Full Stack")
        .body(s);
    }    

}
