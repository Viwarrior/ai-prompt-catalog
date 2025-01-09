package com.avinash.promptstore.authmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.avinash.promptstore.authmanagement.dtos.AuthRequest;
import com.avinash.promptstore.authmanagement.dtos.AuthResponse;
import com.avinash.promptstore.authmanagement.dtos.RegisterRequest;

@Controller
@CrossOrigin("*")
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthResponse> register(RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
