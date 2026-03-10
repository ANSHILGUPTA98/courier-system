package com.courier.courier_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courier.courier_system.model.CourierPackage;
import com.courier.courier_system.repository.CourierPackageRepository;

@Service
public class CourierPackageService {

    @Autowired
    private CourierPackageRepository courierPackageRepository;

    public CourierPackage createPackage(CourierPackage courierPackage) {
        String trackingId = "TRK" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        courierPackage.setTrackingId(trackingId);

        if (courierPackage.getStatus() == null || courierPackage.getStatus().isEmpty()) {
            courierPackage.setStatus("Booked");
        }

        return courierPackageRepository.save(courierPackage);
    }

    public List<CourierPackage> getAllPackages() {
        return courierPackageRepository.findAll();
    }

    public CourierPackage getPackageByTrackingId(String trackingId) {
        return courierPackageRepository.findByTrackingId(trackingId);
    }

    public CourierPackage updateStatus(String trackingId, String status) {
        CourierPackage pkg = courierPackageRepository.findByTrackingId(trackingId);
        if (pkg != null) {
            pkg.setStatus(status);
            return courierPackageRepository.save(pkg);
        }
        return null;
    }
}