package com.github.analuciabolico.arduinomakerbff.dto

data class BlockResponseDto(
    val id: String? = null,
    val name: String? = null,
    val code: String? = null,
    val include: String? = null,
    val type: String? = null,
    val quantity: Int? = null
)

data class BoardResponseDto(
    val type: String? = null,
    val name: String? = null
)