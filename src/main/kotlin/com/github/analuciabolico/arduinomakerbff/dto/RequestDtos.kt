package com.github.analuciabolico.arduinomakerbff.dto

import com.github.analuciabolico.arduinomakerbff.entity.Board

class BoardRequestDto(
    private val type: String? = null,
    private val name: String? = null
) {
    fun toEntity(): Board {
        return Board(this.type, this.name)
    }
}