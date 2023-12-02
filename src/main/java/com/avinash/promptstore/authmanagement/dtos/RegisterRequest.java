package com.avinash.promptstore.authmanagement.dtos;

import java.util.List;

import org.springframework.lang.NonNull;

import com.avinash.promptstore.usermanagement.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NonNull
    private String displayName;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private List<Role> roles;
}
