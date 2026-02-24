package com.kaique.crm.service;

import com.kaique.crm.dto.LoginRequest;
import com.kaique.crm.dto.LoginResponse;
import com.kaique.crm.repository.UserRepository;
import com.kaique.crm.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        var user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
