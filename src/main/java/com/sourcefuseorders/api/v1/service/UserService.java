package com.sourcefuseorders.api.v1.service;

import com.sourcefuseorders.api.v1.dto.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();
}
