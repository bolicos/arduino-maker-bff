package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BlockService {
    fun findAll(): Flux<BlockResponseDto>
    fun findActuators(): Flux<BlockResponseDto>
    fun findSensors(): Flux<BlockResponseDto>
    fun findFixed(): Mono<BlockResponseDto>
}