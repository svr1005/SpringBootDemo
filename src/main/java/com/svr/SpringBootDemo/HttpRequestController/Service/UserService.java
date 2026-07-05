package com.svr.SpringBootDemo.HttpRequestController.Service;

import com.svr.SpringBootDemo.HttpRequestController.Repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final List<User> users = new ArrayList<>();

    public UserService(List<User> user) {
        users.add(new User(1, "Sho", 10));
        users.add(new User(2, "Sho", 11));
        users.add(new User(3, "Sho", 12));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getSingleUser(int id) {
        return users.stream().filter(user -> user.getId() == id).toList().get(0);
    }

    public String addUser(User user) {
        Optional<User> first = users.stream().filter(u -> user.getId() == u.getId()).findFirst();
        if (first.isEmpty()) {
            users.add(user);
            return "User Added";
        }
        return "User Already Exists";
    }

    public User updateUserByID(int id, User user) {
        Optional<User> updatedUser = users.stream().filter(u -> u.getId() == id).findFirst();
        if (updatedUser.isPresent()) {
            if (user.getAge() > 0) {
                updatedUser.get().setAge(user.getAge());
            }
            if (user.getName() != null) {
                updatedUser.get().setName(user.getName());
            }
        }
        return users.stream().filter(u -> u.getId() == id).toList().get(0);
    }
}
