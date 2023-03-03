package com.example.sandbox.service

import com.example.sandbox.entity.Brand
import com.example.sandbox.entity.Generation
import com.example.sandbox.entity.Model
import com.example.sandbox.repo.OnlinerRepository
import com.example.sandbox.repo.BrandRepository
import com.google.gson.JsonParser
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class FillingsTablesService(
    var onlinerRepository: OnlinerRepository,
    var brandRepository: BrandRepository,
) {
    fun execute() {
        var listOfIdBrands = getAllManufacturers().values
        listOfIdBrands.forEach {
            var brandResult = JsonParser.parseString(
                onlinerRepository.getManufacturersInfo(it).block()
            ).asJsonObject
            var newBrand = Brand(
                brandId = brandResult["id"].asInt,
                brandName = brandResult["slug"].asString
            )
            var modelResult = brandResult.get("models").asJsonArray
            var models = mutableSetOf<Model>()
            for (model in modelResult)
            {
                var newModel = Model(
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
                var generations = mutableSetOf<Generation>()
                for (generation in generationResult)
                {
                        var newGeneration = Generation(
                    generationId = generation.asJsonObject.get("id").asInt,
                    generationName = generation.asJsonObject.get("name").asString,
                        )
                    generations.add(newGeneration)
                }
                newModel.generations = generations
                }
            newBrand.models = models
            logger.info("Prepare to import "+newBrand.brandName)
            brandRepository.save(newBrand)
            logger.info("Imported")
        }
        logger.info("Import Done!")
    }

    private fun getAllManufacturers() : Map<String, Int> {
        var allManufacturersJson = JsonParser.parseString(onlinerRepository.getAllManufacturers().block()).asJsonArray
        var result = mutableMapOf<String, Int>()
        for(oneCar in allManufacturersJson) {
            result.put(oneCar.asJsonObject.get("slug").asString, oneCar.asJsonObject.get("id").asInt)
        }
        return result
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}