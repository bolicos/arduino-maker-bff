package com.github.analuciabolico.arduinomakerbff.dto

import com.github.analuciabolico.arduinomakerbff.entity.BlockTypesEnum

data class BlockResponseDto(
    val name: String? = null,
    val code: String? = null,
    val include: String? = null,
    val type: BlockTypesEnum? = null,
    val board: String? = null,
    val quantity: Int? = null
)

data class BoardResponseDto(
    val type: String? = null,
    val name: String? = null
)