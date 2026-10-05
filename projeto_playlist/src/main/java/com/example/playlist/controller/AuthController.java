package com.example.playlist.controller;

import com.example.playlist.dto.AuthRequest;
import com.example.playlist.dto.AuthResponse;
import com.example.playlist.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        userService.register(request);
        return "Usuário registrado com sucesso";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return userService.login(request);
    }
}