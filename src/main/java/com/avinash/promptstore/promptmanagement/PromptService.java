package com.avinash.promptstore.promptmanagement;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.avinash.promptstore.commons.annotations.CustomLogEnabled;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultRequestDTO;
import com.avinash.promptstore.promptmanagement.dtos.PromptDefaultResponseDTO;
import com.avinash.promptstore.promptmanagement.mappers.PromptEntityDTOMapper;
import com.avinash.promptstore.promptmanagement.models.PromptEntity;
import org.springframework.data.domain.Pageable;

@Service
@CustomLogEnabled
public class PromptService {

    private final Logger logger = LoggerFactory.getLogger(PromptService.class);

    private final PromptRepository promptRepository;

    private final PromptEntityDTOMapper promptEntityDTOMapper;

    public PromptService(PromptRepository promptRepository, PromptEntityDTOMapper promptEntityDTOMapper) {
        this.promptRepository = promptRepository;
        this.promptEntityDTOMapper = promptEntityDTOMapper;
    }

    @CustomLogEnabled
    public PromptDefaultResponseDTO createPrompt(PromptDefaultRequestDTO promptDefaultRequestDTO) {
        PromptEntity promptEntity = promptRepository
                .insertPrompt(promptEntityDTOMapper.toEntity(promptDefaultRequestDTO));
        return promptEntityDTOMapper.toDTO(promptEntity);
    }

    public List<PromptDefaultResponseDTO> getAllPromptsPaginated(int page, int size) {
        logger.info("Fetching all prompts with pagination - page: {}, size: {}", page, size);

        Pageable pageable = PageRequest.of(page, size);
        Page<PromptEntity> promptPage = promptRepository.findAll(pageable);

        return promptPage.stream()
                .map(promptEntityDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

}
