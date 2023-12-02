package com.avinash.promptstore.promptmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;

@Controller
public class PromptController implements PromptApi {

    private final Logger logger = LoggerFactory.getLogger(PromptController.class);

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    public ResponseEntity<PromptDefaultResponseDTO> post(@RequestBody PromptDefaultRequestDTO requestPayload) {
        logger.info("Received POST request for prompt");
        PromptDefaultResponseDTO response = promptService.createPrompt(requestPayload);
        return new ResponseEntity<PromptDefaultResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> get() {
        logger.info("Received get request for prompt");
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
