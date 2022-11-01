package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.annotation.MappingJson
import com.github.analuciabolico.arduinomakerbff.annotation.Rest
import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import com.github.analuciabolico.arduinomakerbff.service.BlockService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Rest(value = ["/api/blocks"])
class BlockController(
    private val blockService: BlockService
) {

    @MappingJson
    fun findAll(): Flux<BlockResponseDto> {
        return blockService.findAll()
    }

    @MappingJson(value = ["/actuators"])
    fun findActuators(): Flux<BlockResponseDto> {
        return blockService.findActuators()
    }

    @MappingJson(value = ["/sensors"])
    fun findSensors(): Flux<BlockResponseDto> {
        return blockService.findSensors()
    }

    @MappingJson(value = ["/fixed"])
    fun findFixed(): Mono<BlockResponseDto> {
        return blockService.findFixed()
    }
}