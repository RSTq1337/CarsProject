package com.example.sandbox.service

import com.example.sandbox.entity.onliner.OnlinerBrand
import com.example.sandbox.entity.onliner.OnlinerGeneration
import com.example.sandbox.entity.onliner.OnlinerModel
import com.example.sandbox.repo.onliner.OnlinerRepository
import com.example.sandbox.repo.onliner.OnlinerBrandRepository
import com.google.gson.JsonParser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class OnlinerFillingsTablesService(
    private var onlinerRepository: OnlinerRepository,
    private var onlinerBrandRepository: OnlinerBrandRepository,
) {
    fun execute() {
        var listOfIdBrands = getAllManufacturers().values
        listOfIdBrands.forEach {
            var brandResult = JsonParser.parseString(
                onlinerRepository.getManufacturersInfoById(it).block()
            ).asJsonObject
            var newBrand = OnlinerBrand(
                brandId = brandResult["id"].asInt,
                brandName = brandResult["slug"].asString
            )
            var modelResult = brandResult.get("models").asJsonArray
            var models = mutableSetOf<OnlinerModel>()
            for (model in modelResult)
            {
                var newModel = OnlinerModel(
                    modelId = model.asJsonObject.get("id").asInt,
                    modelName = model.asJsonObject.get("slug").asString,
                    )
                models.add(newModel)
                var generationAnswer = JsonParser.parseString(
                    onlinerRepository.getModelInfo(
                        brandResult["id"].asInt,
                        model.asJsonObject.get("id").asInt
                    ).block()
                ).asJsonObject
                var generationResult = generationAnswer.get("generations").asJsonArray
                var generations = mutableSetOf<OnlinerGeneration>()
                for (generation in generationResult)
                {
                        var newGeneration = OnlinerGeneration(
                    generationId = generation.asJsonObject.get("id").asInt,
                    generationName = generation.asJsonObject.get("name").asString,
                        )
                    generations.add(newGeneration)
                }
                newModel.onlinerGenerations = generations
                }
            newBrand.onlinerModels = models
            logger.info("Prepare to import "+newBrand.brandName)
            onlinerBrandRepository.save(newBrand)
            logger.info("Imported")
        }
        logger.info("Import Done!")
    }

    private fun getAllManufacturers() : Map<String, Int> {
        var allManufacturersJson = JsonParser.parseString(onlinerRepository.getAllManufacturers().block()).asJsonArray
        var result = mutableMapOf<String, Int>()
        for(oneCar in allManufacturersJson) {
            result[oneCar.asJsonObject.get("slug").asString] = oneCar.asJsonObject.get("id").asInt
        }
        return result
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}