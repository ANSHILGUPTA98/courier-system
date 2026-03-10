package com.courier.courier_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.courier_system.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findTopByUserIdOrderByIdDesc(Long userId);
}