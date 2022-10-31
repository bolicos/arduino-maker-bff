package com.github.analuciabolico.arduinomakerbff.repository

import com.github.analuciabolico.arduinomakerbff.entity.Board
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : ReactiveMongoRepository<Board, String>