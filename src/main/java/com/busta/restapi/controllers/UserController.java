package com.busta.restapi.controllers;
import com.busta.restapi.models.User;
import com.busta.restapi.repository.UserRepository;
import com.busta.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public String getUser(){
        return "Getting user";
    }

    @PostMapping("/user/signup")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
