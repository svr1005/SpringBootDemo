package com.svr.SpringBootDemo.HttpRequestController.Controller;

import com.svr.SpringBootDemo.GlobalException.ResourceNotFoundException;
import com.svr.SpringBootDemo.HttpRequestController.DTO.UserRequest;
import com.svr.SpringBootDemo.HttpRequestController.DTO.UserResponse;

import com.svr.SpringBootDemo.HttpRequestController.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<UserResponse> getAllUsers(@PathVariable(name = "id") int userId) {
        UserResponse user = userService.getSingleUser(userId);
        if (user == null) {
            throw new ResourceNotFoundException("UserId with " + userId + " is invalid");
        }
        return ResponseEntity.ok().header("Something").body(user);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserRequest user) {
        String message = userService.addUser(user);
        if (message == null) {
            throw new RuntimeException("User Request Body not correct");
        }
        return ResponseEntity.accepted().body(message);
    }

    @PutMapping("/replace")
    public ResponseEntity<UserResponse> replceUser(@RequestParam int id, @RequestBody UserRequest user) {
        UserResponse userResponse = userService.replaceUserByID(id, user);
        if (userResponse == null) {
            throw new ResourceNotFoundException("UserId with " + id + " is invalid");
        }
        return ResponseEntity.ok().header("Something").body(userResponse);    }

    @PatchMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestParam int id, @RequestBody UserRequest user) {
        UserResponse userResponse = userService.updateUserByID(id, user);
        if (userResponse == null) {
            throw new ResourceNotFoundException("UserId with " + id + " is invalid");
        }
        return ResponseEntity.ok().header("Something").body(userResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable int id) {
        UserResponse userResponse = userService.deleteUserByUserId(id);
        if (userResponse == null) {
            throw new ResourceNotFoundException("UserId with " + id + " is invalid");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("Deleted").body(userResponse);
    }
}
