package com.avinash.promptstore.authmanagement.dtos;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;
}
