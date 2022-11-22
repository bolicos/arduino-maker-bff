package com.github.analuciabolico.arduinomakerbff.entity

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "blocks")
class Block(
    @Id
    private val name: String? = null,
    private val code: String? = null,
    private val include: String? = null,
    private val type: BlockTypesEnum? = null,
    private val board: String? = null,
    private val quantity: Int? = null,
) {
    fun toDto(): BlockResponseDto {
        val id = if (this.name != null) this.name.uppercase() else ""

        return BlockResponseDto(
            id = id,
            name = this.name,
            code = this.code,
            include = this.include,
            type = this.type,
            board = this.board,
            quantity = this.quantity,
        )
    }
}