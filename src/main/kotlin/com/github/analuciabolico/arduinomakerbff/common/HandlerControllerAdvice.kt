package com.github.analuciabolico.arduinomakerbff.common

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.core.codec.DecodingException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.util.logging.Logger

@RestControllerAdvice
class HandlerControllerAdvice {
    companion object {
        private val LOGGER = Logger.getLogger(HandlerControllerAdvice::class.simpleName)
        const val causeMessage = "CAUSE OF EXCEPTION"
        const val defaultMessage = "Internal Server Error"
        val status = HttpStatus.INTERNAL_SERVER_ERROR
    }

    fun factoryErrorMessage(status: HttpStatus, message: String) = ErrorMessageDto(status.value(), message)
    fun factoryErrorCause(throwable: Throwable) {
        val causeException = throwable.toString()
        LOGGER.info(causeMessage)
        LOGGER.warning(causeException)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val message = exception.message ?: defaultMessage
        val errorMessage = factoryErrorMessage(status, message)
        return ResponseEntity(errorMessage, status)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(exception: RuntimeException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val status = HttpStatus.UNPROCESSABLE_ENTITY
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }

    @ExceptionHandler(BusinessEntityNotFoundException::class)
    fun handleBusinessEntityNotFoundException(exception: BusinessEntityNotFoundException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val status = HttpStatus.NOT_FOUND
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }

    @ExceptionHandler(DecodingException::class)
    fun handleDecodingException(exception: DecodingException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val status = HttpStatus.BAD_REQUEST
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    fun handleMissingKotlinParameterException(exception: MissingKotlinParameterException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val status = HttpStatus.BAD_REQUEST
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleNotFoundException(exception: MissingKotlinParameterException): ResponseEntity<ErrorMessageDto> {
        factoryErrorCause(exception)
        val status = HttpStatus.BAD_REQUEST
        val errorMessageDto = ErrorMessageDto(status.value(), exception.message)
        return ResponseEntity(errorMessageDto, status)
    }
}