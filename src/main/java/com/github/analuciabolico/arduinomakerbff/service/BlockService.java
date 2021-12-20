package com.github.analuciabolico.arduinomakerbff.service;

import com.github.analuciabolico.arduinomakerbff.dto.BlockDto;
import com.github.analuciabolico.arduinomakerbff.repository.BlockRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class BlockService {
    private final BlockRepository blockRepository;

    public Flux<BlockDto> findAll() {
        return blockRepository.findAll().map(BlockDto::entityToDto);
    }
}
