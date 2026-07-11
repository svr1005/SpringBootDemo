package com.svr.SpringBootDemo.HttpRequestController.Mapper;

import com.svr.SpringBootDemo.HttpRequestController.DTO.UserRequest;
import com.svr.SpringBootDemo.HttpRequestController.DTO.UserResponse;
import com.svr.SpringBootDemo.HttpRequestController.Repository.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    @Mapping(source="age", target="yearsOld")
    UserResponse UserToUserResponse(User user);

    @Mapping(source="yearsOld", target="age")
    User UserRequestToUser(UserRequest userRequest);
}
