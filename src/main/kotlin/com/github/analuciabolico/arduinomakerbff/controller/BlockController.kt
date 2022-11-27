package com.github.analuciabolico.arduinomakerbff.controller

import com.github.analuciabolico.arduinomakerbff.common.CreatedResource
import com.github.analuciabolico.arduinomakerbff.dto.BlockRequestDto
import com.github.analuciabolico.arduinomakerbff.dto.BlockResponseDto
import com.github.analuciabolico.arduinomakerbff.service.BlockService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/v1/blocks")
class BlockController(
    private val blockService: BlockService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<BlockResponseDto> {
        return blockService.findAll()
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteAll(): Mono<Void> {
        return blockService.deleteAll()
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody dto: BlockRequestDto): Mono<CreatedResource> {
        return blockService.save(dto)
    }

    @PostMapping("/all", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveAll(@RequestBody body: Iterable<BlockRequestDto>): Flux<CreatedResource> {
        val dto = body.toList()
        return blockService.saveAll(dto)
    }

    @GetMapping("/actuators", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findActuators(@RequestParam board: String?): Flux<BlockResponseDto> {
        return blockService.findActuators(board)
    }

    @GetMapping("/sensors", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findSensors(@RequestParam board: String?): Flux<BlockResponseDto> {
        return blockService.findSensors(board)
    }

    @GetMapping("/fixed", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun findFixed(@RequestParam board: String?): Flux<BlockResponseDto> {
        return blockService.findFixed(board)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteById(@PathVariable id: String): Mono<Void> {
        return blockService.deleteById(id)
    }
}