package com.avinash.promptstore.promptmanagement;

import com.avinash.promptstore.promptmanagement.models.PromptEntity;

public interface PromptRepository {

    PromptEntity insertPrompt(PromptEntity promptEntity);

}
