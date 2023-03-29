package com.parsem.parse.service.serivce.api.av

import com.parsem.parse.service.dto.av.AvSearchObject
import com.parsem.parse.service.serivce.api.onliner.ApiOnlinerService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ApiAvService(
    @Qualifier("avWebClient") private var avClient: WebClient
) {


    fun getModelInfoByBrandId(brandId: Int): Mono<String> {
        return avClient
            .get()
            .uri("/offer-types/cars/filters/main/init?brands[0][brand]=$brandId&price_currency=2")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getModelInfoByBrandNameAndModelName(brandId: Int, modelId: Int): Mono<String> {
        return avClient
            .get()
            .uri("/offer-types/cars/filters/main/init?brands[0][brand]=$brandId&brands[0][model]=$modelId&price_currency=2")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    fun getCarsByAllProperties(avSearchObject: AvSearchObject): Mono<String> {
        return if(avSearchObject.brands.size==1 && avSearchObject.models.size==1 && avSearchObject.generations.size==1) {
            logger.debug("Search for ${avSearchObject.brands} - brand")
            avClient
                .get()
                .uri("/offer-types/cars/filters/main/init?brands[0][brand]=${avSearchObject.brands.elementAt(0)}" +
                        "&brands[0][model]=${avSearchObject.models.elementAt(0)}" +
                        "&brands[0][generation]=${avSearchObject.generations.elementAt(0)}")
                .retrieve()
                .bodyToMono(String::class.java)
        }else Mono.empty()
    }
    companion object {
        private val logger = LogManager.getLogger()
    }
}