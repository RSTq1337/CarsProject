package com.parsem.parse.service.serivce.api.onliner

import com.parsem.parse.service.util.RequestHeadersUtil
import org.apache.logging.log4j.LogManager
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ApiOnlinerService(
    private var webClient: WebClient,
) {
    fun getGeneralInfo(): Mono<String> {
        return webClient
            .get()
            .uri("search/vehicles?extended=true&limit=50")
            .retrieve()
            .bodyToMono(String::class.java)
    }
    fun getCarsByBrand(brand: String): Mono<String> {
        val carId = RequestHeadersUtil.mapOfBrands[brand]
        logger.debug("Search for $brand brand with id $carId")
        return webClient
            .get()
            .uri("search/vehicles?car[0][manufacturer]=$carId&extended=true&limit=50")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getPhoneNumberInfo(userId: String): Mono<List<String>> {
        logger.debug("Search for $userId phoneNumber")
        var answer : Mono<List<String>> = Mono.empty();
        try {
            answer = webClient
                .get()
                .uri("vehicles/$userId/phones")
                .retrieve()
                .onStatus({ t: HttpStatus -> t.is4xxClientError} as (HttpStatusCode) -> Boolean) {
                    Mono.error(
                        Throwable("No phone number")
                    )
                }
                .bodyToMono(object : ParameterizedTypeReference<List<String>>() {})

        } catch (ex: Exception) {
            if (ex.message.equals("{\"message\":\"Not Found\"}"))
                return Mono.empty()
        }
        return answer
    }

    private companion object {
        val logger: org.apache.logging.log4j.Logger = LogManager.getLogger()
    }
}