package com.github.analuciabolico.arduinomakerbff.service

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
        return boardRepository.findAll().map { board: Board -> board.toDto() }
    }

    override fun save(boardRequestDto: BoardRequestDto): Mono<String> {
        return boardRepository.save(boardRequestDto.toEntity())
            .doOnSuccess { element: Board ->
                val dto = element.toDto()
                val boardType = dto.type
                println("Save Board Success: $boardType")
            }
            .doOnError { throwable: Throwable -> println("Save Board Error: $throwable") }
            .map { element: Board -> element.toDto().type }
    }
}