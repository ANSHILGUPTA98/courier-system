package com.courier.courier_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.courier.courier_system.model.User;
import com.courier.courier_system.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // public admin registration
    @PostMapping("/register-admin")
    public User registerAdmin(@RequestBody User user) {
        return userService.registerAdmin(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

    // admin creates employee or delivery boy
    @PostMapping("/add-staff")
    public User addStaff(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/logout")
    public String logoutUser(@RequestParam Long userId) {
        return userService.logoutUser(userId);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}