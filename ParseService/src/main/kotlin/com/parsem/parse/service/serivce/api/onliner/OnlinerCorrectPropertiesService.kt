package com.parsem.parse.service.serivce.api.onliner

import com.parsem.parse.service.dto.CarSpecsRequest
import com.parsem.parse.service.dto.onliner.OnlinerSearchObject
import com.parsem.parse.service.repository.onliner.OnlinerBrandRepository
import com.parsem.parse.service.repository.onliner.OnlinerModelRepository
import com.parsem.parse.service.serivce.onliner.OnlinerApiTransferService
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class OnlinerCorrectPropertiesService(
    private val apiOnlinerService: ApiOnlinerService,
    private val onlinerBrandRepository: OnlinerBrandRepository,
    private val onlinerModelRepository: OnlinerModelRepository,
    private val onlinerApiTransferService: OnlinerApiTransferService
) {
    fun getCarsByAllProperties(carSpecsRequest: CarSpecsRequest) {

        val objectForSearch = searchBrand(
            carSpecsRequest.brands.elementAt(0),
            carSpecsRequest.models.elementAt(0),
            carSpecsRequest.generations.elementAt(0))
        var answerFromOnliner = apiOnlinerService.getCarsByAllProperties(objectForSearch)
        var ad = onlinerApiTransferService.transform(answerFromOnliner)
        logger.debug("probably done")
    }

    private fun searchBrand(brandName: String, modelName: String, generationName: String): OnlinerSearchObject {
        val foundedBrand = onlinerBrandRepository.findAllByBrandName(brandName)
        val brandIdForRequest = foundedBrand.brandId
        val modelIdForRequest = foundedBrand.onlinerModels
            .stream().filter{ model -> model.modelName == modelName }.collect(Collectors.toList())[0].modelId


        val generationIdForRequest = onlinerModelRepository.findAllByModelName(modelName)[0].onlinerGenerations
            .stream().filter{ generation -> generation.generationName == generationName }.collect(Collectors.toList())[0].generationId
        return OnlinerSearchObject(setOf(brandIdForRequest), setOf(modelIdForRequest), setOf(generationIdForRequest))
    }

    private companion object {
        val logger: org.apache.logging.log4j.Logger = LogManager.getLogger()
    }
}