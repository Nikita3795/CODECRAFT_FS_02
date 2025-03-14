package com.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import com.example.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
