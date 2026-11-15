package com.sourcefuseorders.api.v1.controller;

import com.sourcefuseorders.api.v1.dto.UserResponse;
import com.sourcefuseorders.api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getAllUser(){
        List<UserResponse> allUsers =  userService.getAllUsers();
        if (allUsers.isEmpty()){
            return null;
        }else {
            return ResponseEntity.ok(allUsers);
        }
    }
}
