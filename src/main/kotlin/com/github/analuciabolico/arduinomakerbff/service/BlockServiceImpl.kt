package com.github.analuciabolico.arduinomakerbff.service

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import com.github.analuciabolico.arduinomakerbff.entity.Block
import com.github.analuciabolico.arduinomakerbff.repository.BlockRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BlockServiceImpl(
    private val blockRepository: BlockRepository
) : BlockService {

    override fun findAll(): Flux<BlockResponseDto> {
        return blockRepository.findAll().map { block: Block -> block.toDto() }
    }

    override fun findActuators(): Flux<BlockResponseDto> {
        return blockRepository
            .findAll()
            .filter { block: Block -> block.toDto().type == "ACTUATOR" }
            .map { block: Block -> block.toDto() }
    }

    override fun findSensors(): Flux<BlockResponseDto> {
        return blockRepository
            .findAll()
            .filter { block: Block -> block.toDto().type == "SENSOR" }
            .map { block: Block -> block.toDto() }
    }

    override fun findFixed(): Mono<BlockResponseDto> {
        return blockRepository
            .findAll()
            .filter { block: Block -> block.toDto().type == "FIXED" }
            .map { block: Block -> block.toDto() }
            .single()
    }
}