package com.avinash.promptstore.promptmanagement;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.avinash.promptstore.promptmanagement.entities.PromptEntity;

@Repository
public class PromptRepositoryImpl implements PromptRepository {

    MongoTemplate  mongoTemplate;

    
    public PromptRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public String insertPrompt(PromptEntity promptEntity) {
        PromptEntity createdPromptEntity = mongoTemplate.insert(promptEntity);
        return createdPromptEntity.getPromptId();
    }
    
}
