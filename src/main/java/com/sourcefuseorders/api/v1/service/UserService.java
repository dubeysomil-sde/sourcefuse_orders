package com.sourcefuseorders.api.v1.service;

import com.sourcefuseorders.api.v1.dto.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(int userId);

    UserResponse deleteUserById(int userId);

    UserResponse createUser(UserResponse userResponse);

    UserResponse updateUser(int userId , UserResponse userResponse);
}
