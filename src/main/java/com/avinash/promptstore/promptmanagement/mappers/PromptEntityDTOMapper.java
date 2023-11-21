package com.avinash.promptstore.promptmanagement.mappers;

import org.springframework.stereotype.Component;

import com.avinash.promptstore.promptmanagement.dtos.PromptDTO;
import com.avinash.promptstore.promptmanagement.entities.PromptEntity;

@Component
public class PromptEntityDTOMapper {
    public PromptDTO toDTO(PromptEntity promptEntity) {
        return PromptDTO.builder().userId(promptEntity.getUserId()).name(promptEntity.getName())
                .description(promptEntity.getDescription()).version(promptEntity.getVersion())
                .content(promptEntity.getContent()).authorId(promptEntity.getAuthorId())
                .verifiedOn(promptEntity.getVerifiedOn()).upvotes(promptEntity.getUpvotes())
                .topicId(promptEntity.getTopicId()).build();
    }

    public PromptEntity toEntity(PromptDTO promptDTO) {
        return PromptEntity.builder().userId(promptDTO.getUserId()).name(promptDTO.getName())
                .description(promptDTO.getDescription()).version(promptDTO.getVersion())
                .content(promptDTO.getContent()).authorId(promptDTO.getAuthorId())
                .verifiedOn(promptDTO.getVerifiedOn()).upvotes(promptDTO.getUpvotes())
                .topicId(promptDTO.getTopicId()).build();
    }
}
