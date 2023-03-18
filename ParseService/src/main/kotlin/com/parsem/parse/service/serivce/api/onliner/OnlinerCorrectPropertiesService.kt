package com.parsem.parse.service.serivce.api.onliner

import com.parsem.parse.service.dto.CarSpecsRequest
import com.parsem.parse.service.dto.OnlinerSearchObject
import com.parsem.parse.service.repository.onliner.OnlinerBrandRepository
import com.parsem.parse.service.repository.onliner.OnlinerGenerationRepository
import com.parsem.parse.service.repository.onliner.OnlinerModelRepository
import org.springframework.stereotype.Service

@Service
class OnlinerCorrectPropertiesService(
    private val apiOnlinerService: ApiOnlinerService,
    private val onlinerBrandRepository: OnlinerBrandRepository,
    private val onlinerModelRepository: OnlinerModelRepository,
    private val onlinerGenerationRepository: OnlinerGenerationRepository
) {
    fun getCarsByAllProperties(carSpecsRequest: CarSpecsRequest) {
        val objectForSearch = OnlinerSearchObject(
            mutableSetOf(searchBrand(carSpecsRequest.brands.elementAt(0))),
            mutableSetOf(searchModel(carSpecsRequest.models.elementAt(0))),
                mutableSetOf(searchGeneration(carSpecsRequest.generations.elementAt(0)))
        )
        apiOnlinerService.getCarsByAllProperties(objectForSearch)  //toDO continue here
    }

    private fun searchBrand(brand: String): Int {
        return onlinerBrandRepository.findAllByBrandName(brand).brandId
    }

    private fun searchModel(model: String): Int {
        return onlinerModelRepository.findAllByModelName(model).modelId
    }

    private fun searchGeneration(generation: String): Int {
        return onlinerGenerationRepository.findAllByGenerationName(generation).generationId
    }
}