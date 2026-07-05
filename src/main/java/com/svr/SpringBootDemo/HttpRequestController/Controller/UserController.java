package com.svr.SpringBootDemo.HttpRequestController.Controller;

import com.svr.SpringBootDemo.HttpRequestController.Repository.User;
import com.svr.SpringBootDemo.HttpRequestController.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public User getAllUsers(@PathVariable(name="id") int userId){
        return userService.getSingleUser(userId);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam int id, @RequestBody User user) {
        return userService.updateUserByID(id,user);
    }

}
