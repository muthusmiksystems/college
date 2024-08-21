package com.spring.budget_master.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.budget_master.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findByUsername(String username);
}
