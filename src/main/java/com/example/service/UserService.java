 package com.example.service;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 import com.example.entity.User;
 import com.example.repository.UserRepository;

 @Service
 @Transactional
 public class UserService {
     private static final Logger logger = LoggerFactory.getLogger(UserService.class);
     private final UserRepository repository;
     private final PasswordEncoder passwordEncoder;

     // Constructor Injection
     public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
         this.repository = repository;
         this.passwordEncoder = passwordEncoder;
     }

     public User saveUser(User user) {
         if (user.getUsername() == null || user.getUsername().isEmpty()) {
             throw new IllegalArgumentException("Username cannot be null or empty");
         }

         if (repository.existsByUsername(user.getUsername())) {
             logger.warn("Attempt to register with existing username: {}", user.getUsername());
             throw new IllegalArgumentException("Username already taken");
         }

         user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
         User savedUser = repository.save(user);
         
         logger.info("User registered successfully: {}", savedUser.getUsername());
         return savedUser;
     }
 }
