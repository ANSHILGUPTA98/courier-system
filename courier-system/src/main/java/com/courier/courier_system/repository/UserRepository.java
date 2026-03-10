package com.courier.courier_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.courier_system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}