package com.sourcefuseorders.api.v1.dto;

import com.sourcefuseorders.api.v1.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {

    private Status status;

    private BigDecimal totalAmount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    List<OrderItemResponse> items;

    private Long userId;
}
