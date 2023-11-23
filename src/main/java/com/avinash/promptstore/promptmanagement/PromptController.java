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
import com.avinash.promptstore.promptmanagement.mappers.PromptEntityDTOMapper;

@Controller
public class PromptController implements PromptApi{

    Logger logger = LoggerFactory.getLogger(PromptController.class);

    PromptService promptService; 

    PromptEntityDTOMapper promptEntityDTOMapper;

    public PromptController(PromptService promptService, PromptEntityDTOMapper promptEntityDTOMapper) {
        this.promptService = promptService;
        this.promptEntityDTOMapper = promptEntityDTOMapper;
    }

    public ResponseEntity<PromptDefaultResponseDTO> post(@RequestBody PromptDefaultRequestDTO requestPayload){
        logger.info("Received POST request for prompt");
        PromptDefaultResponseDTO response = promptService.createPrompt(requestPayload);
        return new ResponseEntity<PromptDefaultResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> get(){
        logger.info("Received get request for prompt");
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
