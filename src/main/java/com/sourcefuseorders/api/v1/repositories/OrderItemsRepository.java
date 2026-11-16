package com.sourcefuseorders.api.v1.repositories;

import com.sourcefuseorders.api.v1.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
