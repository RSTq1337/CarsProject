package com.parsem.webprovider.dto.api

import com.parsem.webprovider.dto.Dto
import com.parsem.webprovider.dto.EngineType

data class CarSpecsRequest(

    val phoneNumber: String,

    val brands: Set<String>,
    val models: Set<String>,
    val generations: Set<String>,
    val fromYear: Int,
    val toYear: Int,
    val fromPrice: Int,
    val fromPriceUSD: Int,
    val toPrice: Int,
    val toPriceUSD: Int,
    val fromEngineVolume: Float,
    val toEngineVolume: Float,
    val fromMileage: Int,
    val toMileage: Int,
    val city: Set<String>,
    val engineTypes: Set<EngineType>,
    val colors: Set<String>

): Dto
