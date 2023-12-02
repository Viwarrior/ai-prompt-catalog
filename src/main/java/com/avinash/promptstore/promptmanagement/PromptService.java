package com.avinash.promptstore.promptmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avinash.promptstore.commons.annotations.CustomLogEnabled;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;
import com.avinash.promptstore.promptmanagement.mappers.PromptEntityDTOMapper;
import com.avinash.promptstore.promptmanagement.models.PromptEntity;

@Service
@CustomLogEnabled
public class PromptService {

    private final Logger logger = LoggerFactory.getLogger(PromptService.class);

    private final PromptRepository promptRepository;

    private final PromptEntityDTOMapper promptEntityDTOMapper;

    public PromptService(PromptRepository promptRepository, PromptEntityDTOMapper promptEntityDTOMapper) {
        this.promptRepository = promptRepository;
        this.promptEntityDTOMapper = promptEntityDTOMapper;
    }
    
    @CustomLogEnabled
    public PromptDefaultResponseDTO createPrompt(PromptDefaultRequestDTO promptDefaultRequestDTO){
        PromptEntity promptEntity = promptRepository.insertPrompt(promptEntityDTOMapper.toEntity(promptDefaultRequestDTO));
        return promptEntityDTOMapper.toDTO(promptEntity);
    }
    
}
