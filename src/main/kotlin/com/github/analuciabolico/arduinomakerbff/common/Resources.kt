package com.github.analuciabolico.arduinomakerbff.common

data class CreatedResource(val id: String?)
data class ErrorMessageDto(
    var status: Int? = null,
    var message: String? = null
)
