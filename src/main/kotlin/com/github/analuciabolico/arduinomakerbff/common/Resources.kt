package com.github.analuciabolico.arduinomakerbff.common

data class CreatedResource(val id: Long)
data class CreatedResourceWithId(val id: String)
data class DeletedResource(val isDelete: Boolean)
data class ErrorMessageDto(
    var status: Int? = null,
    var message: String? = null
)
