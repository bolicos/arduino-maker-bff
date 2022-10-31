package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.annotation.MappingJson
import com.github.analuciabolico.arduinomakerbff.annotation.Rest
import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import com.github.analuciabolico.arduinomakerbff.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Rest(value = ["/boards"])
class BoardController(
    private val boardService: BoardService
) {
    @MappingJson
    fun findAll(): Flux<BoardResponseDto> {
        return boardService.findAll()
    }

    @MappingJson(method = [RequestMethod.POST], code = HttpStatus.CREATED)
    fun save(@RequestBody dto: BoardRequestDto): Mono<String> {
        return boardService.save(dto)
    }
}