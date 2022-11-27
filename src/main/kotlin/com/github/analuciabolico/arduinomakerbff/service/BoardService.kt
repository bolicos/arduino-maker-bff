package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BoardService {
    fun findAll(): Flux<BoardResponseDto>
    fun save(dto: BoardRequestDto): Mono<CreatedResource>
    fun saveAll(body: List<BoardRequestDto>): Flux<CreatedResource>
    fun deleteById(id: String): Mono<Void>
    fun deleteAll(): Mono<Void>
}