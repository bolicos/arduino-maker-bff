package com.github.analuciabolico.arduinomakerbff.service;

import com.github.analuciabolico.arduinomakerbff.dto.BlockDto;
import com.github.analuciabolico.arduinomakerbff.repository.BlockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BlockService {
    private final BlockRepository blockRepository;

    public Flux<BlockDto> findAll() {
        return blockRepository.findAll().map(BlockDto::entityToDto);
    }

    public Flux<BlockDto> findActuators() {
        return blockRepository
                .findAll()
                .filter(block -> block.getType().equals("ACTUATOR"))
                .map(BlockDto::entityToDto);
    }

    public Flux<BlockDto> findSensors() {
        return blockRepository
                .findAll()
                .filter(block -> block.getType().equals("SENSOR"))
                .map(BlockDto::entityToDto);
    }

    public Mono<BlockDto> findFixed() {
        return blockRepository
                .findAll()
                .filter(block -> block.getType().equals("FIXED"))
                .map(BlockDto::entityToDto)
                .single();
    }
}
