package com.example.controller;


import com.example.config.JwtUtil;

import com.example.dto.LoginRequest;
import com.example.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return new AuthResponse(token);
    }
}

