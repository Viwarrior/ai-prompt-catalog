package com.avinash.promptstore.promptmanagement;

import org.springframework.stereotype.Service;

import com.avinash.promptstore.promptmanagement.entities.PromptEntity;

@Service
public class PromptService {
    PromptRepository promptRepository;

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public String createPrompt(PromptEntity promptEntity){
        return promptRepository.insertPrompt(promptEntity);
    }
    
}
