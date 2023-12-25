package com.avinash.promptstore.promptmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PromptDefaultRequestDTO {

    private String name;

    private String description;

    private String content;
}
