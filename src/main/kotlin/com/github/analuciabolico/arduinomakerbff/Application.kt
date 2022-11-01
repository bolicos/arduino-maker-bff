package com.github.analuciabolico.arduinomakerbff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
@ComponentScan(basePackages = ["com.github.analuciabolico.arduinomakerbff.config"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
