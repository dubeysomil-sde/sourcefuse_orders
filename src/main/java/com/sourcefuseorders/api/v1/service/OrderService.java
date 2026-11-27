package com.sourcefuseorders.api.v1.service;

import com.sourcefuseorders.api.v1.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> getAllOrders();
}
