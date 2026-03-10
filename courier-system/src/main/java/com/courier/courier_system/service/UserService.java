package com.courier.courier_system.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.courier.courier_system.model.Session;
import com.courier.courier_system.model.User;
import com.courier.courier_system.repository.SessionRepository;
import com.courier.courier_system.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public User registerAdmin(User user) {
        user.setRole("ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {

            Session session = new Session();
            session.setUser(user);
            session.setLoginTime(LocalDateTime.now().format(formatter));
            sessionRepository.save(session);

            return user;
        }

        return null;
    }

    public String logoutUser(Long userId) {
        Session session = sessionRepository.findTopByUserIdOrderByIdDesc(userId);

        if (session != null && session.getLogoutTime() == null) {
            session.setLogoutTime(LocalDateTime.now().format(formatter));
            sessionRepository.save(session);
            return "Logout successful";
        }

        return "No active session found";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}