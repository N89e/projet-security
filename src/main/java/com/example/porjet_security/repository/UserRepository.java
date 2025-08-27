package com.example.porjet_security.repository;

import com.example.porjet_security.usersData.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Integer> {
    Optional<UserApp> findByUsername(String username);
}

