package com.java.SpringBootProject.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringBootProject.core.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
				User findByEmail(String email);
}
