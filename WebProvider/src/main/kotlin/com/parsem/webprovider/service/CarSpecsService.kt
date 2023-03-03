package com.parsem.webprovider.service

import com.parsem.webprovider.dto.api.CarSpecsRequest

interface CarSpecsService {
    fun sendMessage(carSpecsRequest: CarSpecsRequest)
}