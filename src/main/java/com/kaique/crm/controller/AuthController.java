package com.kaique.crm.controller;

import com.kaique.crm.dto.LoginRequest;
import com.kaique.crm.dto.LoginResponse;
import com.kaique.crm.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
