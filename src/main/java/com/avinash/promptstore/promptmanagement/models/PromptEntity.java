package com.avinash.promptstore.promptmanagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "prompt")
@Data
@Builder
public class PromptEntity {

    @Id
    private String promptId;

    private String name;

    private String description;

    @Builder.Default
    private int version = 1;

    private String content;
    
}
