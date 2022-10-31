package com.github.analuciabolico.arduinomakerbff.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Arduino Maker API")
//            .packagesToScan("com.github.analuciabolico.arduinomakerbff")
//            .pathsToMatch("/v1/**")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun configOpenAPI(): OpenAPI {
        val version = "0.0.1-SNAPSHOT"
        val description = "Arduino Maker API"
        val license = License().name("MIT").url("https://mit-license.org")
        val contact = Contact()
            .name("Ana Lucia Bolico")
            .url("https://github.com/analuciabolico")
            .email("analuciabolico.dev@gmail.com")
        val info = Info()
            .title("Arduino Maker")
            .description(description)
            .license(license)
            .contact(contact)
            .version(version)
        val externalDocumentation = ExternalDocumentation()
            .description("Wiki")
            .url("https://github.com/analuciabolico/arduino-maker-bff/wiki")

        return OpenAPI().info(info).externalDocs(externalDocumentation)
    }
}