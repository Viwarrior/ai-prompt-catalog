package com.avinash.promptstore.promptmanagement;

import com.avinash.promptstore.promptmanagement.entities.PromptEntity;

public interface PromptRepository {

    String insertPrompt(PromptEntity promptEntity);

}
