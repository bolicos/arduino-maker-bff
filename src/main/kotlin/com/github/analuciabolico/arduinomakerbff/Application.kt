package com.github.analuciabolico.arduinomakerbff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}