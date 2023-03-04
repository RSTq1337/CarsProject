package com.example.sandbox.repo.onliner

import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class OnlinerRepository (
    @Qualifier("onlinerWebClient") private var onlinerClient: WebClient
)
{
    fun getAllManufacturers(): Mono<String> {
        return onlinerClient
            .get()
            .uri("manufacturers")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getManufacturersInfoById(id: Int): Mono<String> {
        logger.debug("Get Manufacturer Info for $id;")
        return onlinerClient
            .get()
            .uri("manufacturers/$id")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getModelInfo(idManufacter: Int, idModel: Int): Mono<String> {
        logger.debug("Get Manufacturer Info for $idManufacter and $idModel Model;")
        return onlinerClient
            .get()
            .uri("manufacturers/$idManufacter/models/$idModel")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getGenerationInfo(idManufacter: Int, idModel: Int, idGeneration: Int): Mono<String> {
        logger.debug("Get Manufacturer Info for $idManufacter and $idModel Model for $idGeneration generation;")
        return onlinerClient
            .get()
            .uri("manufacturers/$idManufacter/model/$idModel/generations/$idGeneration")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}