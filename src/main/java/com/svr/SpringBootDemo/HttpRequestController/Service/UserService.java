package com.svr.SpringBootDemo.HttpRequestController.Service;

import com.svr.SpringBootDemo.HttpRequestController.DTO.UserRequest;
import com.svr.SpringBootDemo.HttpRequestController.DTO.UserResponse;
import com.svr.SpringBootDemo.HttpRequestController.Mapper.UserMapper;
import com.svr.SpringBootDemo.HttpRequestController.Repository.User;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {


    private final List<User> users = new ArrayList<>();

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public UserService(List<User> user) {
        users.add(new User(1, "Shourya", 27));
        users.add(new User(2, "Shourya", 18));
        users.add(new User(3, "Shourya", 18));
    }

    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponses = users.stream().map(userMapper::UserToUserResponse).toList();
        return userResponses;
    }

    public UserResponse getSingleUser(int id) {
        Optional<User> singleUser = users.stream().filter(user -> user.getId() == id).findFirst();
        return singleUser.map(user -> userMapper.UserToUserResponse(user)).orElse(null);
    }

    public String addUser(UserRequest user) {
        Optional<User> userToAdd = users.stream().filter(u -> user.getId() == u.getId()).findFirst();
        if (userToAdd.isPresent()) {
            return null;
        }
        else {
            users.add(userMapper.UserRequestToUser(user));
            return "User Request Added "+ user.toString();
        }
    }

    public UserResponse updateUserByID(int id, UserRequest user) {
        Optional<User> updatedUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        if (updatedUser.isPresent()) {
            users.remove(id-1);
            if (user.getYearsOld() > 0) {
                updatedUser.get().setAge(user.getYearsOld());
            }
            if (user.getName() != null) {
                updatedUser.get().setName(user.getName());
            }
            users.add(id-1,userMapper.UserRequestToUser(user));
        }
        return userMapper.UserToUserResponse(users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null));
    }

    public UserResponse replaceUserByID(int id, UserRequest user) {
        User updatedUser = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if(updatedUser!=null) {
            users.remove(id-1);
            if(user.getYearsOld()>0 && user.getId()>0 && user.getName()!=null) {
                users.add(id-1,userMapper.UserRequestToUser(user));
            }
        }
        return userMapper.UserToUserResponse(users.stream().filter(u -> u.getId() == id).findFirst().orElse(null));

    }

    public UserResponse deleteUserByUserId(int id) {
        User userToBeDelted = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (userToBeDelted!=null) {
            users.remove(userToBeDelted);
            return userMapper.UserToUserResponse(userToBeDelted);
        }
        else {
            return null;
        }
    }
}
