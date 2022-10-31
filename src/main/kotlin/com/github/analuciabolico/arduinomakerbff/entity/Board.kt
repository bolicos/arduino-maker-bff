package com.github.analuciabolico.arduinomakerbff.entity

import com.github.analuciabolico.arduinomakerbff.dto.BoardResponseDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "boards")
class Board(
    @Id
    private val type: String? = null,
    private val name: String? = null
) {
    fun toDto(): BoardResponseDto {
        return BoardResponseDto(name = this.name, type = this.type)
    }
}