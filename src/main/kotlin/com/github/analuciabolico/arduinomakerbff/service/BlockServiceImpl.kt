package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
import com.github.analuciabolico.arduinomakerbff.dto.BlockRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import com.github.analuciabolico.arduinomakerbff.entity.Block
import com.github.analuciabolico.arduinomakerbff.entity.BlockTypesEnum
import com.github.analuciabolico.arduinomakerbff.repository.BlockRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BlockServiceImpl(
    private val blockRepository: BlockRepository
) : BlockService {

    override fun findAll(): Flux<BlockResponseDto> {
        return blockRepository
            .findAll()
            .map { block: Block -> block.toDto() }
    }

    override fun save(dto: BlockRequestDto): Mono<CreatedResource> {
        return blockRepository.save(dto.toEntity())
            .doOnSuccess { element: Block ->
                val response = element.toDto()
                val blockId = response.name
                println("Save Block Success: [$blockId].")
            }
            .doOnError { throwable: Throwable -> println("Save Block Error: [$throwable].") }
            .mapNotNull { element: Block -> CreatedResource(element.toDto().name) }
    }

    override fun saveAll(body: List<BlockRequestDto>): Flux<CreatedResource> {
        return blockRepository.saveAll(body.map { it.toEntity() })
            .doOnNext { element: Block ->
                val response = element.toDto()
                val blockId = response.name
                println("Save Block Success: [$blockId].")
            }
            .doOnError { throwable: Throwable -> println("Save Block Error: [$throwable].") }
            .mapNotNull { element: Block -> CreatedResource(element.toDto().name) }
    }

    override fun findActuators(board: String?): Flux<BlockResponseDto> {
        val type = BlockTypesEnum.ACTUATOR

        return when (board) {
            null -> findByType(type)
            "" -> findByType(type)
            else -> findByType(type, board)
        }
    }

    override fun findSensors(board: String?): Flux<BlockResponseDto> {
        val type = BlockTypesEnum.SENSOR

        return when (board) {
            null -> findByType(type)
            "" -> findByType(type)
            else -> findByType(type, board)
        }
    }

    override fun findFixed(board: String?): Mono<BlockResponseDto> {
        val type = BlockTypesEnum.FIXED

        return when (board) {
            null -> findByType(type).single()
            "" -> findByType(type).single()
            else -> findByType(type, board).singleOrEmpty()
        }
    }

    private fun findByType(type: BlockTypesEnum): Flux<BlockResponseDto> {
        println("Find Blocks with type [$type].")
        return blockRepository.findAllByType(type).map { block: Block -> block.toDto() }
    }

    private fun findByType(type: BlockTypesEnum, board: String): Flux<BlockResponseDto> {
        println("Find Blocks with type [$type] and board [$board].")
        return blockRepository.findAllByTypeAndBoard(type, board).map { block: Block -> block.toDto() }
    }
}