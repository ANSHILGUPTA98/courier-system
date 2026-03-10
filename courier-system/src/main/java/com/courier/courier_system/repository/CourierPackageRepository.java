package com.courier.courier_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.courier_system.model.CourierPackage;

public interface CourierPackageRepository extends JpaRepository<CourierPackage, Long> {

    CourierPackage findByTrackingId(String trackingId);

}