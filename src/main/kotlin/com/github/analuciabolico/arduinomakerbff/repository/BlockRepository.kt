package com.github.analuciabolico.arduinomakerbff.repository

import com.github.analuciabolico.arduinomakerbff.entity.Block
import com.github.analuciabolico.arduinomakerbff.entity.BlockTypesEnum
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface BlockRepository : ReactiveMongoRepository<Block, String> {
    fun findAllByType(type: BlockTypesEnum): Flux<Block>
    fun findAllByTypeAndBoard(type: BlockTypesEnum, board: String): Flux<Block>
}