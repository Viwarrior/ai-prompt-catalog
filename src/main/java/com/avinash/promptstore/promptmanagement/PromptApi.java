package com.avinash.promptstore.promptmanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RequestMapping(name = "prompts", value = "/api/v1/prompts", consumes = "application/json", produces = "application/json")
public interface PromptApi {
    @Operation(summary = "create prompt", description = "creates a new prompt")
    	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "create prompt", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = PromptDefaultResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "bad request", content = @Content)})
    @PostMapping
    ResponseEntity<PromptDefaultResponseDTO> post(@RequestBody PromptDefaultRequestDTO requestPayload);
}
