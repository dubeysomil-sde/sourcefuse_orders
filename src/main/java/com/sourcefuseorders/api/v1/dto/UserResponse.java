package com.sourcefuseorders.api.v1.dto;

import com.sourcefuseorders.api.v1.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserResponse {

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private List<Order> orders;
}
