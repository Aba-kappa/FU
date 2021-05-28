package com.example.Blog_GladkiyNS_PI194.repositories;

import com.example.Blog_GladkiyNS_PI194.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    static Optional<User> findByEmailAndPassword(String email, String password) {
        return null;
    }
}
