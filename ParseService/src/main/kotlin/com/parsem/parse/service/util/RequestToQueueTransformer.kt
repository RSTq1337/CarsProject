package com.parsem.parse.service.util

import com.parsem.parse.service.dto.CarSpecsRequest
import com.parsem.parse.service.dto.CarSpecsRequestQueue
import java.text.SimpleDateFormat
import java.util.*

class RequestToQueueTransformer {
    companion object {
        fun toRequestQueue(carSpecsRequest: CarSpecsRequest): CarSpecsRequestQueue {

            val sdf = SimpleDateFormat("hhmmssms")
            val currentDate = sdf.format(Date())

            return CarSpecsRequestQueue(
                requestId = carSpecsRequest.phoneNumber+currentDate,
                phoneNumber = carSpecsRequest.phoneNumber,
                brands = carSpecsRequest.brands,
                models = carSpecsRequest.models,
                generations = carSpecsRequest.generations,
                fromYear = carSpecsRequest.fromYear,
                toYear = carSpecsRequest.toYear,
                fromPrice = carSpecsRequest.fromPrice,
                fromPriceUSD = carSpecsRequest.fromPriceUSD,
                toPrice = carSpecsRequest.toPrice,
                toPriceUSD = carSpecsRequest.toPriceUSD,
                fromEngineVolume = carSpecsRequest.fromEngineVolume,
                toEngineVolume = carSpecsRequest.toEngineVolume,
                fromMileage = carSpecsRequest.fromMileage,
                toMileage = carSpecsRequest.toMileage,
                city = carSpecsRequest.city,
                engineTypes = carSpecsRequest.engineTypes,
                colors = carSpecsRequest.colors)
        }

        fun fromRequestQueue(carSpecsRequestQueue: CarSpecsRequestQueue): CarSpecsRequest {

            return CarSpecsRequest(
                phoneNumber = carSpecsRequestQueue.phoneNumber,
                brands = carSpecsRequestQueue.brands,
                models = carSpecsRequestQueue.models,
                generations = carSpecsRequestQueue.generations,
                fromYear = carSpecsRequestQueue.fromYear,
                toYear = carSpecsRequestQueue.toYear,
                fromPrice = carSpecsRequestQueue.fromPrice,
                fromPriceUSD = carSpecsRequestQueue.fromPriceUSD,
                toPrice = carSpecsRequestQueue.toPrice,
                toPriceUSD = carSpecsRequestQueue.toPriceUSD,
                fromEngineVolume = carSpecsRequestQueue.fromEngineVolume,
                toEngineVolume = carSpecsRequestQueue.toEngineVolume,
                fromMileage = carSpecsRequestQueue.fromMileage,
                toMileage = carSpecsRequestQueue.toMileage,
                city = carSpecsRequestQueue.city,
                engineTypes = carSpecsRequestQueue.engineTypes,
                colors = carSpecsRequestQueue.colors)
        }
    }
}