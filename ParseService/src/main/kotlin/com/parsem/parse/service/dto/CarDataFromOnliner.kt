package com.parsem.parse.service.dto

data class CarDataFromOnliner(
    val title: String = "",
    val authorId: String = "",
    val brand: String = "",
    val model: String = "",
    val generation: String = "",
    val transmission: String = "",
    val odometer: String = "",
    val year: String = "",
    val color: String = "",
    val bodyType: String = "",
    val state: String = "",
    val driveTrain: String = "",
    val modification: String? = "",
    val engineType: String? = "",
    val engineCapacity: String? = "",
    val engineTorque: String? = "",
    val enginePower: String? = "",
    val sellerNumber: List<String>? = mutableListOf(),
    val priceUSD: String = "",
    val priceBYN: String = "",
    val imagesOG: Set<String> = emptySet(),
    val images1900: Set<String> = emptySet(),
    val images800: Set<String> = emptySet(),
    val images600: Set<String> = emptySet(),
    val images380: Set<String> = emptySet(),
    val images100: Set<String> = emptySet(),
    val images80: Set<String> = emptySet(),
    val created: String = "",
    val url: String = "",
): Dto
