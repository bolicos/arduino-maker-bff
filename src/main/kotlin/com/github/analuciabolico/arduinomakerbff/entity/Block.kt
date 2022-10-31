package com.github.analuciabolico.arduinomakerbff.entity

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "classes")
class Block(
    @Id
    private val id: String? = null,
    private val name: String? = null,
    private val code: String? = null,
    private val include: String? = null,
    private val type: String? = null,
    private val quantity: Int? = null,
) {
    fun toDto(): BlockResponseDto {
        return BlockResponseDto(
            id = this.id,
            name = this.name,
            code = this.code,
            include = this.include,
            type = this.type,
            quantity = this.quantity
        )
    }
}