package com.github.analuciabolico.arduinomakerbff.controller;

import com.github.analuciabolico.arduinomakerbff.dto.BlockDto;
import com.github.analuciabolico.arduinomakerbff.service.BlockService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/blocks")
public class BlockController {
    private final BlockService blockRepository;


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Flux<BlockDto> findAll() {
        return blockRepository.findAll();
    }
}