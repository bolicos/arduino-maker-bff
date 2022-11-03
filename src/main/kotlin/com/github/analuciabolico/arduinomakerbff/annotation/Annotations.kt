package com.github.analuciabolico.arduinomakerbff.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


/**
 * Annotation for mapping RestControllers
 *
 * @see RequestMapping
 */
@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RestController
@RequestMapping
annotation class Rest(
    /**
     * Alias for [RequestMapping.name].
     */
    @get:AliasFor(annotation = RequestMapping::class) val name: String = "",

    /**
     * Alias for [RequestMapping.value].
     */
    @get:AliasFor(annotation = RequestMapping::class) vararg val value: String = [],

    /**
     * Alias for [RequestMapping.path].
     */
    @get:AliasFor(annotation = RequestMapping::class) val path: Array<String> = []
)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@RequestMapping
annotation class MappingJson(
    /**
     * Alias for [RequestMapping.name].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "name")
    val name: String = "",

    /**
     * Alias for [RequestMapping.value].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "value")
    val value: Array<String> = [],

    /**
     * Alias for [RequestMapping.path].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: Array<String> = [],

    /**
     * Alias for [RequestMapping.method].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "method")
    val method: Array<RequestMethod> = [RequestMethod.GET],
//    val method: Array<RequestMethod> = [],

    /**
     * Alias for [RequestMapping.params].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "params")
    val params: Array<String> = [],

    /**
     * Alias for [RequestMapping.headers].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "headers")
    val headers: Array<String> = [],

    /**
     * Alias for [RequestMapping.consumes].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "consumes")
    val consumes: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    /**
     * Alias for [RequestMapping.produces].
     */
    @get:AliasFor(annotation = RequestMapping::class, attribute = "produces")
    val produces: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    /**
     * Alias for [ResponseStatus.code].
     */
    @get:AliasFor(annotation = ResponseStatus::class, attribute = "code")
    val code: HttpStatus = HttpStatus.OK,
)