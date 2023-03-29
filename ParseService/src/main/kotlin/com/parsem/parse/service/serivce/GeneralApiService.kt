package com.parsem.parse.service.serivce

import com.parsem.parse.service.dto.CarSpecsRequestQueue
import com.parsem.parse.service.serivce.api.av.ApiAvService
import com.parsem.parse.service.serivce.api.av.AvCorrectPropertiesService
import com.parsem.parse.service.serivce.api.onliner.ApiOnlinerService
import com.parsem.parse.service.serivce.api.onliner.OnlinerCorrectPropertiesService
import com.parsem.parse.service.serivce.av.AvApiTransferService
import com.parsem.parse.service.serivce.onliner.OnlinerApiTransferService
import com.parsem.parse.service.util.RequestToQueueTransformer
import org.springframework.stereotype.Service

@Service
class GeneralApiService(
    private val onlinerCorrectPropertiesService: OnlinerCorrectPropertiesService,
    private val avCorrectPropertiesService: AvCorrectPropertiesService,
    private val apiAvService: ApiAvService
) {
    fun fullSearch(carSpecsRequestQueue: CarSpecsRequestQueue) {
        var specsRequest =  RequestToQueueTransformer.fromRequestQueue(carSpecsRequestQueue)
        onlinerCorrectPropertiesService.getCarsByAllProperties(specsRequest)

        avCorrectPropertiesService.getCarsByAllProperties(specsRequest)
    }
}