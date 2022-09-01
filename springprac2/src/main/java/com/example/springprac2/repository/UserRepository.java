package com.example.springprac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springprac2.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByKakaoId(String kakaoId);

    Optional<User> findByEmail(String email);
}