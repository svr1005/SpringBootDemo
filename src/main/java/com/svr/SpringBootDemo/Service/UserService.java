package com.svr.SpringBootDemo.Service;

import com.svr.SpringBootDemo.Repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    User user;

    public User getAllUsers() {
        user.setId(UUID.randomUUID());
        user.setName("Shourya");
        user.setAge(22);

        System.out.println("User : " + user);

        return user;
    }


}
