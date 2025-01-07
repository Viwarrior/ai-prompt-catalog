package com.avinash.promptstore.authmanagement;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.avinash.promptstore.authmanagement.dtos.AuthRequest;
import com.avinash.promptstore.authmanagement.dtos.AuthResponse;
import com.avinash.promptstore.authmanagement.dtos.RegisterRequest;
import com.avinash.promptstore.usermanagement.UserRepository;
import com.avinash.promptstore.usermanagement.UserService;
import com.avinash.promptstore.usermanagement.models.UserEntity;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthService(UserRepository repository, JwtService jwtService,
            AuthenticationManager authenticationManager, UserService userService) {
        this.userRepository = repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    public AuthResponse register(RegisterRequest request) {
        UserEntity user = userService.createUser(request);
        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    public AuthResponse login(AuthRequest request) {

        UserEntity user = userRepository.getUserByUsername(request.getUsername()).get();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

}
