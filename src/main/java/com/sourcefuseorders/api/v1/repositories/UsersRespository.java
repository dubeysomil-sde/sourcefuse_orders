package com.sourcefuseorders.api.v1.repositories;

import com.sourcefuseorders.api.v1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRespository extends JpaRepository<Users, Integer> {
}
