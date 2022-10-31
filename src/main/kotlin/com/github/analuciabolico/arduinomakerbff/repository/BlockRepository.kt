package com.github.analuciabolico.arduinomakerbff.repository

import com.github.analuciabolico.arduinomakerbff.entity.Block
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BlockRepository : ReactiveMongoRepository<Block, String>