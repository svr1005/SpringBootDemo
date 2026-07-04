package com.svr.SpringBootDemo.Controller;

import com.svr.SpringBootDemo.Repository.User;
import com.svr.SpringBootDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public User getAllUsers(){
        return userService.getAllUsers();
    }
}
