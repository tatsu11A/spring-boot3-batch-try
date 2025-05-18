package com.example.springboot3batchtry.repository;

import com.example.springboot3batchtry.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}

