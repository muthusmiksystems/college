package com.spring.budget_master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.budget_master.modal.User;
import com.spring.budget_master.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	 	public User registerUser(User user) {
	 		 // Encrypt the password
	        user.setPassword((user.getPassword()));

	        // Set default role if not provided
//	        if (user.getRole() == null || user.getRole().isEmpty()) {
//	        	user.setRole("USER");
//	        }
	        // Perform validation and hashing of password
	        return userRepository.save(user);
	    }
	 	
	 	public User loginUser(String username, String password) {
	        Optional<User> user = userRepository.findByUsername(username);
	        if (user.isPresent()) {
	            return user.get();
	        }
	        throw new RuntimeException("Invalid credentials");
	    }
	 	
	 	
}
