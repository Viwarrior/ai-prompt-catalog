package com.avinash.promptstore.promptmanagement.entities;

import java.util.List;
import java.util.UUID;

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
