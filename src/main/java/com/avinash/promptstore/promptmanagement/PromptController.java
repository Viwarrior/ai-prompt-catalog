package com.avinash.promptstore.promptmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avinash.promptstore.promptmanagement.dtos.PromptDTO;
import com.avinash.promptstore.promptmanagement.mappers.PromptEntityDTOMapper;

@Controller
@RequestMapping(name = "prompts", value = "/api/v1/prompts", consumes = "application/json", produces = "application/json")
public class PromptController {

    Logger logger = LoggerFactory.getLogger(PromptController.class);

    PromptService promptService; 

    PromptEntityDTOMapper promptEntityDTOMapper;

    public PromptController(PromptService promptService, PromptEntityDTOMapper promptEntityDTOMapper) {
        this.promptService = promptService;
        this.promptEntityDTOMapper = promptEntityDTOMapper;
    }

    @PostMapping
    public ResponseEntity<PromptDTO> post(){
        PromptDTO promptDTO = new PromptDTO(null, "name", null, null, null, null, null, 0, null);
        promptService.createPrompt(promptEntityDTOMapper.toEntity(promptDTO));
        return new ResponseEntity<PromptDTO>(promptDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> get(){
        logger.info("Received get request for prompt");
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
