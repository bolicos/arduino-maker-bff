package com.github.analuciabolico.arduinomakerbff.entity

import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "blocks")
class Block(
    @Id
    private val id: ObjectId? = ObjectId(),
    private val name: String? = null,
    private val code: String? = null,
    private val include: String? = null,
    private val type: BlockTypesEnum? = null,
    private val board: String? = null,
    private val quantity: Int? = null,
) {
    fun toDto(): BlockResponseDto {
        return BlockResponseDto(
            id = this.id.toString(),
            name = this.name,
            code = this.code,
            include = this.include,
            type = this.type,
            board = this.board,
            quantity = this.quantity,
        )
    }
}