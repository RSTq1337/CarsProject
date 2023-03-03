package com.parsem.webprovider.service

import com.parsem.webprovider.dto.CarSpecsRequestQueue
import com.parsem.webprovider.dto.api.CarSpecsRequest
import com.parsem.webprovider.service.rabbit.ProduceCarSpecsService
import com.parsem.webprovider.util.RequestToQueueTransformer
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service


@Service
class CarSpecsServiceImpl(
    private val produceCarSpecsService: ProduceCarSpecsService
): CarSpecsService {

    override fun sendMessage(carSpecsRequest: CarSpecsRequest) {
        val car: CarSpecsRequestQueue = RequestToQueueTransformer.toRequestQueue(carSpecsRequest)
        this.produceCarSpecsService.produceMessage(car.toString())
        logger.info("Car request was created: $car")
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}