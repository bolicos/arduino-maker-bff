package com.github.analuciabolico.arduinomakerbff.controller;

import com.github.analuciabolico.arduinomakerbff.dto.BlockDto;
import com.github.analuciabolico.arduinomakerbff.service.BlockService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/blocks")
public class BlockController {
    private final BlockService blockService;


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Flux<BlockDto> findAll() {
        return blockService.findAll();
    }

    @GetMapping(
            path = "/actuators",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Flux<BlockDto> findActuators() {
        return blockService.findActuators();
    }

    @GetMapping(
            path = "/sensors",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Flux<BlockDto> findSensors() {
        return blockService.findSensors();
    }

    @GetMapping(
            path = "/fixed",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Mono<BlockDto> findFixed() {
        return blockService.findFixed();
    }
}