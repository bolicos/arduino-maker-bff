package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import com.github.analuciabolico.arduinomakerbff.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/boards")
class BoardController(
    private val boardService: BoardService
) {

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<BoardResponseDto> {
        return boardService.findAll()
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody dto: BoardRequestDto): Mono<String> {
        return boardService.save(dto)
    }
}