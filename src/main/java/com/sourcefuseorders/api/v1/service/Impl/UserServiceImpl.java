package com.sourcefuseorders.api.v1.service.Impl;

import com.sourcefuseorders.api.v1.dto.UserResponse;
import com.sourcefuseorders.api.v1.entity.User;
import com.sourcefuseorders.api.v1.repositories.UsersRespository;
import com.sourcefuseorders.api.v1.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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

    @Override
    public UserResponse getUserById(int userId) {
        User user = usersRespository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }else{
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail().toLowerCase());
            userResponse.setName(user.getName());
            userResponse.setCreatedAt(user.getCreatedAt());
            userResponse.setOrders(user.getOrders());
            return userResponse;
        }
    }

    @Override
    public UserResponse deleteUserById(int userId) {
        UserResponse userResponse = getUserById(userId);
        if (userResponse == null) {
            return null;
        } else {
            usersRespository.deleteById(userId);
            return userResponse;
        }
    }

    @Override
    public UserResponse createUser(UserResponse userResponse) {
        User user = new User();
        user.setName(userResponse.getName());
        user.setEmail(userResponse.getEmail().toLowerCase());
        user.setCreatedAt(userResponse.getCreatedAt());
        user.setOrders(userResponse.getOrders());
        usersRespository.save(user);
        return userResponse;
    }

    @Override
    public UserResponse updateUser(int userId, UserResponse userResponse) {
        User user = usersRespository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        } else {
            user.setName(userResponse.getName());
            user.setEmail(userResponse.getEmail().toLowerCase());
            user.setCreatedAt(userResponse.getCreatedAt());
            user.setOrders(userResponse.getOrders());
            usersRespository.save(user);
            return userResponse;
        }
    }
}
