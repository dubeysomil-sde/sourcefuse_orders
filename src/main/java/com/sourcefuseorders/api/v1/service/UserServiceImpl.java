package com.sourcefuseorders.api.v1.service;

import com.sourcefuseorders.api.v1.dto.UserResponse;
import com.sourcefuseorders.api.v1.entity.User;
import com.sourcefuseorders.api.v1.repositories.UsersRespository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UsersRespository usersRespository;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = usersRespository.findAll();

        List<UserResponse> userList = users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setEmail(user.getEmail().toLowerCase());
            userResponse.setCreatedAt(user.getCreatedAt());
            userResponse.setOrders(user.getOrders());
            return userResponse;
        }).toList();

        return userList;
    }
}
