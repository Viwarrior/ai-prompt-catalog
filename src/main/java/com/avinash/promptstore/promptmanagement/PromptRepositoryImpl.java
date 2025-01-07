package com.avinash.promptstore.promptmanagement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.avinash.promptstore.promptmanagement.models.PromptEntity;

@Repository
public class PromptRepositoryImpl implements PromptRepository {

    private final MongoTemplate  mongoTemplate;

    
    public PromptRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public PromptEntity insertPrompt(PromptEntity promptEntity) {
        PromptEntity createdPromptEntity = mongoTemplate.insert(promptEntity);
        return createdPromptEntity;
    }


    @Override
    public Page<PromptEntity> findAll(Pageable pageable) {
        Query query = new Query().with(pageable);
        List<PromptEntity> prompts = mongoTemplate.find(query, PromptEntity.class);
        long total = mongoTemplate.count(query.skip(0).limit(0), PromptEntity.class);
        return PageableExecutionUtils.getPage(prompts, pageable, () -> total);
    }
    
}
