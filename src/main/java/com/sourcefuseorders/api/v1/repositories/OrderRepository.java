package com.sourcefuseorders.api.v1.repositories;

import com.sourcefuseorders.api.v1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
