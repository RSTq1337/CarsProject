package com.example.sandbox.service

import com.example.sandbox.entity.av.AvBrand
import com.example.sandbox.entity.av.AvFixBrand
import com.example.sandbox.entity.av.AvGeneration
import com.example.sandbox.entity.av.AvModel
import com.example.sandbox.repo.av.AvRepository
import com.example.sandbox.repo.av.db.AvBrandRepository
import com.example.sandbox.repo.av.db.AvFixBrandRepository
import com.google.gson.JsonParser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AvFillingsTablesService(
    var avRepository: AvRepository,
    var avFixBrandRepository: AvFixBrandRepository,
    var avBrandRepository: AvBrandRepository
) {
    fun getAllModels(): List<AvBrand> {
        var setOfAllManufacturers = getAllManufacturers()
        setOfAllManufacturers.forEach { brand ->
            var setOfAllModelsForBrand = getAllModels(brand.brandId)
            setOfAllModelsForBrand.forEach{model ->
                var setOfAllGenerationsForModel = getAllGenerations(brand.brandId, model.modelId)
                model.avGenerations = setOfAllGenerationsForModel
            }
            brand.avModels = setOfAllModelsForBrand
            avBrandRepository.save(brand)
            logger.debug("${brand.brandName} saved.")
            }
        logger.debug("done")
        return mutableListOf<AvBrand>()
        }


    private fun getAllManufacturers(): Set<AvBrand> {
        val allManufacturersJson = JsonParser.parseString(avRepository.getAllManufacturers().block())
            .asJsonObject.getAsJsonArray("blocks")
            .get(0).asJsonObject
            .getAsJsonArray("rows").get(0).asJsonObject
            .getAsJsonArray("propertyGroups").get(0).asJsonObject
            .getAsJsonArray("properties").get(0).asJsonObject
            .getAsJsonArray("value").get(0).asJsonArray
            .get(1).asJsonObject.getAsJsonArray("options").asJsonArray

        var avBrands= mutableSetOf<AvBrand>()
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

    private fun getAllModels(brandId: Int): Set<AvModel> {
        val allModels = JsonParser.parseString(avRepository.getModelInfoByBrandId(brandId).block())
            .asJsonObject.getAsJsonArray("blocks")
            .get(0).asJsonObject
            .getAsJsonArray("rows").get(0).asJsonObject
            .getAsJsonArray("propertyGroups").get(0).asJsonObject
            .getAsJsonArray("properties").get(0).asJsonObject
            .getAsJsonArray("value").get(0).asJsonArray
            .get(2).asJsonObject
            .getAsJsonArray("options").asJsonArray
        var setOfModels = mutableSetOf<AvModel>()
        for (oneModel in allModels) {
            setOfModels.add(AvModel(
                oneModel.asJsonObject.get("id").asInt,
                oneModel.asJsonObject.get("label").asString
            ))
        }
        return setOfModels
    }

    private fun getAllGenerations(brandId: Int, modelId: Int): Set<AvGeneration> {
        val allGenerations = JsonParser.parseString(avRepository.getModelInfoByBrandNameAndModelName(brandId, modelId).block())
            .asJsonObject.getAsJsonArray("blocks")
            .get(0).asJsonObject
            .getAsJsonArray("rows").get(0).asJsonObject
            .getAsJsonArray("propertyGroups").get(0).asJsonObject
            .getAsJsonArray("properties").get(0).asJsonObject
            .getAsJsonArray("value").get(0).asJsonArray
            .get(3).asJsonObject
            .getAsJsonArray("options").asJsonArray
        var setOfGenerations = mutableSetOf<AvGeneration>()
        for (oneGeneration in allGenerations) {
            setOfGenerations.add(
                AvGeneration(
                    oneGeneration.asJsonObject.get("id").asInt,
                    oneGeneration.asJsonObject.get("label").asString
                ))
        }
        return setOfGenerations
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}