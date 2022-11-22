package com.github.analuciabolico.arduinomakerbff.serialization

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.analuciabolico.arduinomakerbff.dto.BoardRequestDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Serialization {

    private val mapper: ObjectMapper = jacksonObjectMapper()

    @Test
    fun whenSerializeMovie_thenSuccess() {
        val request = BoardRequestDto("BOARD_1", "TEST_1")
        val serialized = mapper.writeValueAsString(request)

        println("AQUI")
        println(request)
        println(serialized)

        val json = """{"type":"BOARD_1","name":"TEST_1"}"""

        assertEquals(serialized, json)
    }
}