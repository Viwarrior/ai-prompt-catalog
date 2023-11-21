package com.avinash.promptstore.promptmanagement.dtos;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PromptDTO {
        
    private UUID userId;

    private String name;

    private String description;

    private String version;

    private String content;

    private UUID authorId;

    private List<String> verifiedOn;

    private int upvotes;

    private UUID topicId;
}
