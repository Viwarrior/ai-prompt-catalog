package com.avinash.promptstore.promptmanagement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(name = "prompts", value = "/api/v1/prompts")
@CrossOrigin("*")
public interface PromptApi {
        @Operation(summary = "create prompt", description = "creates a new prompt")
        @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "create prompt", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = PromptDefaultResponseDTO.class)) }),
                        @ApiResponse(responseCode = "400", description = "bad request", content = @Content) })
        @PostMapping
        ResponseEntity<PromptDefaultResponseDTO> post(@RequestBody PromptDefaultRequestDTO requestPayload);

        @Operation(summary = "get prompts", description = "gets prompts")
        @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get prompts", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
                        @ApiResponse(responseCode = "400", description = "bad request", content = @Content) })
        @GetMapping
        public ResponseEntity<List<PromptDefaultResponseDTO>> getAllPrompts(
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size);

        @Operation(summary = "search prompts", description = "gets prompts")
        @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get prompts", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
                        @ApiResponse(responseCode = "400", description = "bad request", content = @Content) })
        @GetMapping("/search")
        public ResponseEntity<List<PromptDefaultResponseDTO>> searchPrompt(
                        @RequestParam(defaultValue = "") String query,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size);
}
