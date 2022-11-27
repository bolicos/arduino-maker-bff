package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import com.github.analuciabolico.arduinomakerbff.entity.Board
import com.github.analuciabolico.arduinomakerbff.repository.BoardRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BoardServiceImpl(
    private val boardRepository: BoardRepository
) : BoardService {

    override fun findAll(): Flux<BoardResponseDto> {
        return boardRepository
            .findAll()
            .doFinally { println("Find All Boards") }
            .map { board: Board -> board.toDto() }
    }

    override fun save(dto: BoardRequestDto): Mono<CreatedResource> {
        return boardRepository.save(dto.toEntity())
            .doOnSuccess { element: Board ->
                val response = element.toDto()
                val boardType = response.type
                println("Save Board Success: $boardType")
            }
            .doOnError { throwable: Throwable -> println("Save Board Error: ${throwable.message}") }
            .mapNotNull { element: Board -> CreatedResource(element.toDto().type) }
    }

    override fun saveAll(body: List<BoardRequestDto>): Flux<CreatedResource> {
        return boardRepository.saveAll(body.map { it.toEntity() })
            .doOnNext { element: Board ->
                val response = element.toDto()
                val boardType = response.type
                println("Save Board Success: $boardType")
            }
            .doOnError { throwable: Throwable -> println("Save Board Error: ${throwable.message}") }
            .mapNotNull { element: Board -> CreatedResource(element.toDto().type) }
    }

    override fun deleteById(id: String): Mono<Void> {
        return boardRepository
            .deleteById(id)
            .doOnSuccess { println("Delete Board By $id") }
    }

    override fun deleteAll(): Mono<Void> {
        return boardRepository
            .deleteAll()
            .doOnSuccess { println("Delete All Boards") }
    }
}