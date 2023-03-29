package com.parsem.parse.service.serivce.api.av

import com.parsem.parse.service.dto.CarSpecsRequest
import com.parsem.parse.service.dto.av.AvSearchObject
import com.parsem.parse.service.repository.av.AvBrandRepository
import com.parsem.parse.service.repository.av.AvModelRepository
import com.parsem.parse.service.serivce.av.AvApiTransferService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AvCorrectPropertiesService(
    private val apiAvService: ApiAvService,
    private val avBrandRepository: AvBrandRepository,
    private val avModelRepository: AvModelRepository,
    private val avApiTransferService: AvApiTransferService
) {
    fun getCarsByAllProperties(carSpecsRequest: CarSpecsRequest) {
        val objectForSearch = searchBrand(
            carSpecsRequest.brands.elementAt(0),
            carSpecsRequest.models.elementAt(0),
            carSpecsRequest.generations.elementAt(0))
        var answerFromAv = apiAvService.getCarsByAllProperties(objectForSearch)
        var transform = avApiTransferService.transform(answerFromAv)
    }

    private fun searchBrand(brandName: String, modelName: String, generationName: String): AvSearchObject {
        val foundedBrand = avBrandRepository.findAllByBrandName(brandName)
        val brandIdForRequest = foundedBrand.brandId
        val modelIdForRequest = foundedBrand.avModels
            .stream().filter{ model -> model.modelName.lowercase() == modelName}.collect(Collectors.toList())[0].modelId

        val generationIdForRequest = avModelRepository.findAllByModelName(modelName)[0].avGenerations
            .stream().filter{ generation -> generation.generationName == generationName }.collect(Collectors.toList())[0].generationId
        return AvSearchObject(setOf(brandIdForRequest), setOf(modelIdForRequest), setOf(generationIdForRequest))
    }
}