package com.sourcefuseorders.api.v1.repositories;

import com.sourcefuseorders.api.v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRespository extends JpaRepository<User, Integer> {
}
