package com.example.sandbox.repo.av

import com.example.sandbox.repo.onliner.OnlinerRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class AvRepository (
    @Qualifier("avWebClient") private var onlinerClient: WebClient
) {
    fun getAllManufacturers(): Mono<String> {
        return onlinerClient
            .get()
            .uri("/offer-types/cars/filters/main/init?price_currency=2")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getManufacturersInfoByBrandName(brandName: String): Mono<String> {
        logger.debug("Get Manufacturer Info for $brandName;")
        return onlinerClient
            .get()
            .uri("https://api.av.by/offer-types/cars/landings/$brandName")
            .retrieve()
            .bodyToMono(String::class.java)
    }
    companion object {
        private val logger = LogManager.getLogger()
    }
}