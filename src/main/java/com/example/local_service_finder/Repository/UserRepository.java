package com.example.local_service_finder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.local_service_finder.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
