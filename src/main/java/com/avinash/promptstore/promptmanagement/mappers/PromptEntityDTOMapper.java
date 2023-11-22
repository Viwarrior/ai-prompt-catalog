package com.avinash.promptstore.promptmanagement.mappers;

import org.springframework.stereotype.Component;

import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;
import com.avinash.promptstore.promptmanagement.entities.PromptEntity;

@Component
public class PromptEntityDTOMapper {
    public PromptDefaultResponseDTO toDTO(PromptEntity promptEntity) {
        return PromptDefaultResponseDTO.builder().name(promptEntity.getName()).description(promptEntity.getDescription())
                .version(promptEntity.getVersion()).content(promptEntity.getContent()).build();
    }

    public PromptEntity toEntity(PromptDefaultRequestDTO promptDefaultRequestDTO) {
        return PromptEntity.builder().name(promptDefaultRequestDTO.getName()).description(promptDefaultRequestDTO.getDescription())
                .content(promptDefaultRequestDTO.getContent()).build();
    }
}
