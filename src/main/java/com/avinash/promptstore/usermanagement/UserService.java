package com.avinash.promptstore.usermanagement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avinash.promptstore.authmanagement.dtos.RegisterRequest;
import com.avinash.promptstore.usermanagement.mappers.UserEntityDTOMapper;
import com.avinash.promptstore.usermanagement.models.UserEntity;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserEntityDTOMapper userEntityDTOMapper;

    public UserService(UserRepository userRepository, UserEntityDTOMapper userEntityDTOMapper) {
        this.userRepository = userRepository;
        this.userEntityDTOMapper = userEntityDTOMapper;
    }

    public UserEntity createUser(RegisterRequest registerRequest) {
        return userRepository.insertUser(userEntityDTOMapper.toEntity(registerRequest));

    }

    public UserEntity getUserByUsername(String username){
        return userRepository.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}