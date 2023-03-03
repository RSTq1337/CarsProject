package com.parsem.parse.service.serivce.api.onliner

import com.parsem.parse.service.util.RequestHeadersUtil
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
        return webClient
            .get()
            .uri("search/vehicles?car[0][manufacturer]=$carId&extended=true&limit=50")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getPhoneNumberInfo(userId: String): Mono<List<String>> {
        var answer : Mono<List<String>> = Mono.empty();
        try {
            answer = webClient
                .get()
                .uri("vehicles/$userId/phones")
                .retrieve()
                .onStatus(
                    { other: HttpStatusCode? ->
                        HttpStatus.NOT_FOUND == other
                    }
                ) { response: ClientResponse ->
                    response.bodyToMono(
                        String::class.java
                    )
                        .map { message: String? ->
                            Exception(
                                message
                            )
                        }
                }
                .bodyToMono(object : ParameterizedTypeReference<List<String>>() {})
        } catch (ex: Exception) {
            if (ex.message.equals("{\"message\":\"Not Found\"}"))
                return Mono.empty()
        }
        return answer
    }
}