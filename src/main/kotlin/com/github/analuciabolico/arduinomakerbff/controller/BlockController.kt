package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import com.github.analuciabolico.arduinomakerbff.service.BlockService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/v1/blocks")
class BlockController(
    private val blockService: BlockService
) {

    @GetMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<BlockResponseDto> {
        return blockService.findAll()
    }

    @GetMapping("/actuators", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findActuators(): Flux<BlockResponseDto> {
        return blockService.findActuators()
    }

    @GetMapping("/sensors", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findSensors(): Flux<BlockResponseDto> {
        return blockService.findSensors()
    }

    @GetMapping("/fixed", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findFixed(): Mono<BlockResponseDto> {
        return blockService.findFixed()
    }
}