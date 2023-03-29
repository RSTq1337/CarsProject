package com.parsem.parse.service.serivce.av

import com.google.gson.JsonParser
import com.parsem.parse.service.dto.av.CarDataFromAv
import com.parsem.parse.service.serivce.api.av.ApiAvService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AvApiTransferService(
    private var apiAvService: ApiAvService
) {

    fun transform(jsonMono: Mono<String>): Set<CarDataFromAv> {
        val normalJson = JsonParser.parseString(jsonMono.block()).asJsonObject
        return setOf()
    }
}