package com.github.analuciabolico.arduinomakerbff.dto

import com.github.analuciabolico.arduinomakerbff.entity.Block
import com.github.analuciabolico.arduinomakerbff.entity.BlockTypesEnum
import com.github.analuciabolico.arduinomakerbff.entity.Board

data class BoardRequestDto(
    val type: String? = null,
    val name: String? = null
) {
    fun toEntity(): Board {
        return Board(this.type, this.name)
    }
}

data class BlockRequestDto(
    val name: String? = null,
    val code: String? = null,
    val include: String? = null,
    val type: BlockTypesEnum? = null,
    val board: String? = null,
    val quantity: Int? = null
) {
    fun toEntity(): Block {
        return Block(
            name = this.name,
            code = this.code,
            include = this.include,
            type = this.type,
            board = this.board,
            quantity = this.quantity,
        )
    }
}