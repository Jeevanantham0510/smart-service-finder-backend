package com.example.local_service_finder.Controller;

import com.example.local_service_finder.Dto.AuthRequest;
import com.example.local_service_finder.Dto.AuthResponse;
import com.example.local_service_finder.Entity.User;
import com.example.local_service_finder.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://172.16.20.123:3000"
})
public class AuthController {

    private final UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        user.setRole("USER"); // Every registered user is USER

        return repo.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return new AuthResponse(
                "Login Successful",
                user.getId(),
                user.getRole()
        );
    }
}