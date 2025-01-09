package com.avinash.promptstore.promptmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class PromptDefaultResponseDTO {

    private String name;

    private String description;

    private int version;

    private String content;
}
