package com.courier.courier_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.courier.courier_system.model.CourierPackage;
import com.courier.courier_system.service.CourierPackageService;

@RestController
@RequestMapping("/courier")
public class CourierPackageController {

    @Autowired
    private CourierPackageService courierPackageService;

    @PostMapping("/create")
    public CourierPackage createPackage(@RequestBody CourierPackage courierPackage) {
        return courierPackageService.createPackage(courierPackage);
    }

    @GetMapping("/all")
    public List<CourierPackage> getAllPackages() {
        return courierPackageService.getAllPackages();
    }

    @GetMapping("/track/{trackingId}")
    public CourierPackage trackPackage(@PathVariable String trackingId) {
        return courierPackageService.getPackageByTrackingId(trackingId);
    }

    @PutMapping("/update/{trackingId}")
    public CourierPackage updateStatus(@PathVariable String trackingId, @RequestParam String status) {
        return courierPackageService.updateStatus(trackingId, status);
    }
}