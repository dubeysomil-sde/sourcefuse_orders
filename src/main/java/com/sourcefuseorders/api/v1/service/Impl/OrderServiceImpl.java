package com.sourcefuseorders.api.v1.service.Impl;

import com.sourcefuseorders.api.v1.dto.OrderResponse;
import com.sourcefuseorders.api.v1.entity.Order;
import com.sourcefuseorders.api.v1.repositories.OrderRepository;
import com.sourcefuseorders.api.v1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepo;

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orderList = orderRepo.findAll();
        if (orderList.isEmpty()) {
            return List.of();
        } else {

            return orderList.stream().map(order -> {
                        OrderResponse orderRespo = new OrderResponse();
                        orderRespo.setStatus(order.getStatus());
                        orderRespo.setTotalAmount(order.getTotalAmount());
                        orderRespo.setCreatedAt(order.getCreatedAt());
                        orderRespo.setUpdatedAt(order.getUpdatedAt());

                        return orderRespo;
                    }
            ).toList();
        }
    }
}
