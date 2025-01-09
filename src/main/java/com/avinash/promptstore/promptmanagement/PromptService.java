package com.avinash.promptstore.promptmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avinash.promptstore.commons.annotations.CustomLogEnabled;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;
import com.avinash.promptstore.promptmanagement.mappers.PromptEntityDTOMapper;
import com.avinash.promptstore.promptmanagement.models.PromptEntity;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
@CustomLogEnabled
public class PromptService {

    private final Logger logger = LoggerFactory.getLogger(PromptService.class);

    private final PromptRepository promptRepository;

    private final RestTemplate restTemplate;

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

    private final PromptEntityDTOMapper promptEntityDTOMapper;

    public PromptService(PromptRepository promptRepository, PromptEntityDTOMapper promptEntityDTOMapper,
            RestTemplate restTemplate) {
        this.promptRepository = promptRepository;
        this.promptEntityDTOMapper = promptEntityDTOMapper;
        this.restTemplate = restTemplate;
    }

    @CustomLogEnabled
    public PromptDefaultResponseDTO createPrompt(PromptDefaultRequestDTO promptDefaultRequestDTO) {
        // Save the prompt in the database
        PromptEntity promptEntity = promptRepository
                .insertPrompt(promptEntityDTOMapper.toEntity(promptDefaultRequestDTO));
        PromptDefaultResponseDTO responseDTO = promptEntityDTOMapper.toDTO(promptEntity);

        // Add the prompt to the Elasticsearch index
        try {
            String url = elasticsearchUrl + "/prompts/_doc"; // URL for Elasticsearch index
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Convert the DTO to a JSON string
            String elasticsearchPayload = new com.fasterxml.jackson.databind.ObjectMapper()
                    .writeValueAsString(responseDTO);

            // Prepare the request
            HttpEntity<String> request = new HttpEntity<>(elasticsearchPayload, headers);

            // Send the POST request to Elasticsearch
            restTemplate.postForObject(url, request, String.class);

            logger.info("Prompt successfully added to Elasticsearch index 'prompts' with ID: {}",
                    responseDTO.getVersion());
        } catch (Exception e) {
            logger.error("Failed to add prompt to Elasticsearch. ID: {}, Error: {   }", responseDTO.getVersion(),
                    e.getMessage());
        }

        return responseDTO;
    }

    public List<PromptDefaultResponseDTO> getAllPromptsPaginated(int page, int size) {
        logger.info("Fetching all prompts with pagination - page: {}, size: {}", page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<PromptEntity> promptPage = promptRepository.findAll(pageable);

        return promptPage.stream()
                .map(promptEntityDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Search prompts by any field (name, description, content) with pagination
    public List<PromptDefaultResponseDTO> searchPromptsByKey(String query, int page, int size) {
        String searchQuery = createSearchQuery(query, page, size);
        return searchInElasticsearch(searchQuery);
    }

    // Helper method to create the search query with pagination
    private String createSearchQuery(String query, int page, int size) {
        return "{\n" +
                "  \"query\": {\n" +
                "    \"multi_match\": {\n" +
                "      \"query\": \"" + query + "\",\n" +
                "      \"fields\": [\"name\", \"description\", \"content\"]\n" +
                "    }\n" +
                "  },\n" +
                "  \"from\": " + (page * size) + ",\n" +
                "  \"size\": " + size + "\n" +
                "}";
    }

    // Helper method to query Elasticsearch and map the response to DTOs
    private List<PromptDefaultResponseDTO> searchInElasticsearch(String query) {
        String url = elasticsearchUrl + "/prompts/_search";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(query, headers);
        String response = restTemplate.postForObject(url, request, String.class);

        // Parse the Elasticsearch response
        return parseElasticsearchResponse(response);
    }

    // Parse Elasticsearch response into a list of DTOs
    private List<PromptDefaultResponseDTO> parseElasticsearchResponse(String response) {
        List<PromptDefaultResponseDTO> prompts = new ArrayList<>();
        try {
            JsonNode rootNode = new com.fasterxml.jackson.databind.ObjectMapper().readTree(response);
            JsonNode hitsNode = rootNode.path("hits").path("hits");
            for (JsonNode hit : hitsNode) {
                JsonNode sourceNode = hit.path("_source");
                PromptDefaultResponseDTO prompt = new com.fasterxml.jackson.databind.ObjectMapper()
                        .treeToValue(sourceNode, PromptDefaultResponseDTO.class);
                prompts.add(prompt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prompts;
    }
}
