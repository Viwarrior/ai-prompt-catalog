package com.avinash.promptstore.usermanagement;

import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.avinash.promptstore.usermanagement.models.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository {

    final private MongoTemplate mongoTemplate;

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return Optional.ofNullable(mongoTemplate.findOne(query, UserEntity.class));
    }

    @Override
    public UserEntity insertUser(UserEntity userEntity) {
        UserEntity createdUserEntity = mongoTemplate.insert(userEntity);
        return createdUserEntity;
    }

}
