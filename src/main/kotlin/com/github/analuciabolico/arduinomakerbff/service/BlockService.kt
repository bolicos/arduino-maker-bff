package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
import com.github.analuciabolico.arduinomakerbff.dto.BlockRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BlockService {
    fun findAll(): Flux<BlockResponseDto>
    fun save(dto: BlockRequestDto): Mono<CreatedResource>
    fun saveAll(body: List<BlockRequestDto>): Flux<CreatedResource>
    fun findActuators(board: String?): Flux<BlockResponseDto>
    fun findSensors(board: String?): Flux<BlockResponseDto>
    fun findFixed(board: String?): Mono<BlockResponseDto>
}