package com.avinash.promptstore.authmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avinash.promptstore.authmanagement.dtos.AuthRequest;
import com.avinash.promptstore.authmanagement.dtos.AuthResponse;
import com.avinash.promptstore.authmanagement.dtos.RegisterRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(name = "auth", value = "/api/v1/auth", consumes = "application/json", produces = "application/json")
public interface AuthApi {
        @Operation(summary = "user register", description = "registers a new user")
        @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "user registered", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class)) }),
                        @ApiResponse(responseCode = "400", description = "bad request", content = @Content) })
        @PostMapping("register")
        ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest requestPayloa);

        @Operation(summary = "user login", description = "logs in an user")
        @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "user logged in", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class)) }),
                        @ApiResponse(responseCode = "400", description = "bad request", content = @Content) })
        @PostMapping("login")
        ResponseEntity<AuthResponse> login(@RequestBody AuthRequest requestPayload);
}
