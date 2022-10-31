package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BoardService {
    fun findAll(): Flux<BoardResponseDto>
    fun save(boardRequestDto: BoardRequestDto): Mono<String>
}