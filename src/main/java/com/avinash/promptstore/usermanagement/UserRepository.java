package com.avinash.promptstore.usermanagement;

import java.util.Optional;

import com.avinash.promptstore.usermanagement.models.UserEntity;

public interface UserRepository {

    Optional<UserEntity> getUserByUsername(String username);

    UserEntity insertUser(UserEntity userEntity);

}
