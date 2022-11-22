package com.github.analuciabolico.arduinomakerbff.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
@EnableWebFlux
class WebFluxConfiguration : WebFluxConfigurer {

    companion object {
        const val nullToEmptyCollection = true
        const val nullToEmptyMap = true
        const val nullIsSameAsDefault = true
        const val singletonSupport = false
        const val strictNullChecks = false
        const val writeDatesAsTimesTamp = false
        const val writeDateTimesTampAsNanoseconds = false
        const val failOnUnknownProperties = false
        const val acceptEmptyArrayAsNullObject = true
    }

    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        val module = KotlinModule.Builder()
            .configure(KotlinFeature.NullToEmptyCollection, nullToEmptyCollection)
            .configure(KotlinFeature.NullToEmptyMap, nullToEmptyMap)
            .configure(KotlinFeature.NullIsSameAsDefault, nullIsSameAsDefault)
            .configure(KotlinFeature.SingletonSupport, singletonSupport)
            .configure(KotlinFeature.StrictNullChecks, strictNullChecks)
            .build()

        val mapper = ObjectMapper()
            .registerModule(JavaTimeModule())
            .registerModule(module)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, writeDatesAsTimesTamp)
            .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, writeDateTimesTampAsNanoseconds)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties)
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, acceptEmptyArrayAsNullObject)
            .configure(DeserializationFeature.FAIL_ON_TRAILING_TOKENS, false)
            .configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false)

        val decoder = Jackson2JsonDecoder(mapper)
        val encoder = Jackson2JsonEncoder(mapper)

        configurer.defaultCodecs().jackson2JsonDecoder(decoder)
        configurer.defaultCodecs().jackson2JsonEncoder(encoder)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins("*")
            .allowedHeaders("*")
            .allowCredentials(false)
            .maxAge(3600)
    }
}