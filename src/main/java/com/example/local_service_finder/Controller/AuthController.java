package com.example.local_service_finder.Controller;

import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.example.local_service_finder.Repository.UserRepository;
import com.example.local_service_finder.Entity.User;
import com.example.local_service_finder.Dto.*;

@RestController
@RequestMapping("/api/auth")
@Table(name="user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setRole("USER");
        userRepository.save(user);
        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new AuthResponse("Login Successful", user.getRole());
    }
}