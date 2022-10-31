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

@RequestMapping(
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@ResponseStatus
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class MappingJson(
    /**
     * Alias for [RequestMapping.name].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val name: String = "",

    /**
     * Alias for [RequestMapping.value].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val value: Array<String> = [],

    /**
     * Alias for [RequestMapping.path].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val path: Array<String> = [],

    /**
     * Alias for [RequestMapping.method].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val method: Array<RequestMethod> = [RequestMethod.GET],

    /**
     * Alias for [RequestMapping.params].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val params: Array<String> = [],

    /**
     * Alias for [RequestMapping.headers].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val headers: Array<String> = [],

    /**
     * Alias for [RequestMapping.consumes].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val consumes: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    /**
     * Alias for [RequestMapping.produces].
     */
    @get:AliasFor(annotation = RequestMapping::class)
    val produces: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    /**
     * Alias for [ResponseStatus.code].
     */
    @get:AliasFor(annotation = ResponseStatus::class)
    val code: HttpStatus = HttpStatus.OK,
)
