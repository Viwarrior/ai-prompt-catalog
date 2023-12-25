package com.avinash.promptstore.usermanagement.mappers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.avinash.promptstore.authmanagement.dtos.RegisterRequest;
import com.avinash.promptstore.usermanagement.models.UserEntity;

@Component
public class UserEntityDTOMapper {

    private final PasswordEncoder passwordEncoder;

    public UserEntityDTOMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity toEntity(RegisterRequest dto) {
        return UserEntity
                .builder()
                .displayName(dto.getDisplayName())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .build();

    }
}
