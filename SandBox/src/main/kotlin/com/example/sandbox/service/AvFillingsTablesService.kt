package com.example.sandbox.service

import com.example.sandbox.entity.av.AvBrand
import com.example.sandbox.entity.av.AvFixBrand
import com.example.sandbox.entity.av.AvModel
import com.example.sandbox.repo.av.AvRepository
import com.example.sandbox.repo.av.db.AvFixBrandRepository
import com.google.gson.JsonParser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AvFillingsTablesService(
    var avRepository: AvRepository,
    var avFixBrandRepository: AvFixBrandRepository
) {
    fun getAllModels(): List<AvBrand> {
        var listOfAllManufacturers = getAllManufacturers()
        listOfAllManufacturers.forEach {
            var brandInfo = JsonParser.parseString(
                avRepository.getManufacturersInfoByBrandName(it.brandName).block()
            ).asJsonObject
            var modelId = brandInfo.get("initialValue").asString.subSequence(17, brandInfo.get("initialValue").asString.indexOf('&')).toString().toInt()
            var listOfModels = mutableListOf<AvModel>()
            for (oneModel in brandInfo.get("seo").asJsonObject.get("links").asJsonArray) {
                var newModel = AvModel(
                    modelId,
                    oneModel.asJsonObject.get("label").asString.lowercase(),
                    oneModel.asJsonObject.get("url").asString,
                )
                var modelInfo = JsonParser.parseString(
                    avRepository.getModelInfoByBrandNameAndModelName(it.brandName,oneModel.asJsonObject.get("label").asString.lowercase()).block()
                ).asJsonObject

            }
            logger.debug(brandInfo)
        }
        return listOfAllManufacturers
    }
    fun getAllManufacturers(): List<AvBrand> {
        val allManufacturersJson = JsonParser.parseString(avRepository.getAllManufacturers().block())
            .asJsonObject.getAsJsonArray("blocks")
            .get(0).asJsonObject
            .getAsJsonArray("rows").get(0).asJsonObject
            .getAsJsonArray("propertyGroups").get(0).asJsonObject
            .getAsJsonArray("properties").get(0).asJsonObject
            .getAsJsonArray("value").get(0).asJsonArray
            .get(1).asJsonObject.getAsJsonArray("options").asJsonArray

        var avBrands= mutableListOf<AvBrand>()
        val fixesForBrands = avFixBrandRepository.findAll();
        for (oneCar in allManufacturersJson) {
            var filteredFix = fixesForBrands.stream().filter{ it.brandNameSource == oneCar.asJsonObject.get("label").asString.lowercase() }.collect(
                Collectors.toList())
            if (filteredFix.isEmpty()) {
                avBrands.add(
                    AvBrand(
                        oneCar.asJsonObject.get("intValue").asInt,
                        oneCar.asJsonObject.get("label").asString.lowercase().replace(' ','-')
                    )
                )
            } else {
                avBrands.add(
                    AvBrand(
                        oneCar.asJsonObject.get("intValue").asInt,
                        filteredFix[0].brandNameCorrect
                    )
                )
            }
        }
        return avBrands
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}