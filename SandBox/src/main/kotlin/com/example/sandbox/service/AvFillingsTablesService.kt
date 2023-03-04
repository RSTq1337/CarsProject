package com.example.sandbox.service

import com.example.sandbox.repo.av.AvRepository
import com.google.gson.JsonParser
import org.springframework.stereotype.Service

@Service
class AvFillingsTablesService(
    var avRepository: AvRepository,
) {
    fun getAllManufacturers(): Map<String, Int> {
        var allManufacturersJson = JsonParser.parseString(avRepository.getAllManufacturers().block())
            .asJsonObject.getAsJsonArray("blocks")
            .get(0).asJsonObject
            .getAsJsonArray("rows").get(0).asJsonObject
            .getAsJsonArray("propertyGroups").get(0).asJsonObject
            .getAsJsonArray("properties").get(0).asJsonObject
            .getAsJsonArray("value").get(0).asJsonArray
            .get(1).asJsonObject.getAsJsonArray("options").asJsonArray

        var result = mutableMapOf<String, Int>()
        for (oneCar in allManufacturersJson) {
            result[oneCar.asJsonObject.get("label").asString.lowercase()] = oneCar.asJsonObject.get("intValue").asInt
        }
        return result
    }
}