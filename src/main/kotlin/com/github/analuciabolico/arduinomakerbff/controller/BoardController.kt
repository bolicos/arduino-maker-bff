package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
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

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<BoardResponseDto> {
        return boardService.findAll()
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody dto: BoardRequestDto): Mono<CreatedResource> {
        return boardService.save(dto)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteAll(): Mono<Void> {
        return boardService.deleteAll()
    }

    @PostMapping("/all", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveAll(@RequestBody body: Iterable<BoardRequestDto>): Flux<CreatedResource> {
        val dto = body.toList()
        return boardService.saveAll(dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteById(@PathVariable id: String): Mono<Void> {
        return boardService.deleteById(id)
    }
}