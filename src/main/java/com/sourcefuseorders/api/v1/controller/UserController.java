package com.sourcefuseorders.api.v1.controller;

import com.sourcefuseorders.api.v1.dto.UserResponse;
import com.sourcefuseorders.api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") int userId){
        UserResponse user = userService.getUserById(userId);
        if (user == null){
            return null;
        }else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/user/{id}")
    public  ResponseEntity<UserResponse> deleteUserById(@PathVariable("id") int userId){
        UserResponse deletedUser = userService.deleteUserById(userId);
        return ResponseEntity.ok(deletedUser);
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserResponse userResponse){
        UserResponse createdUser = userService.createUser(userResponse);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserResponse updatedUserDetail, @PathVariable("id") int userId) {
        UserResponse updatedUser = userService.updateUser(userId, updatedUserDetail);
        return ResponseEntity.ok(updatedUser);
    }
}
