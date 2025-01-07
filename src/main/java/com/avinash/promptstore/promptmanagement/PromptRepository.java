package com.avinash.promptstore.promptmanagement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avinash.promptstore.promptmanagement.models.PromptEntity;

public interface PromptRepository {

    PromptEntity insertPrompt(PromptEntity promptEntity);

    Page<PromptEntity> findAll(Pageable pageable);

}
