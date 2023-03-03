package com.parsem.webprovider.dto

data class CarSpecsRequestQueue(

    val requestId: String,
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

) :Dto {
    override fun toString(): String {
        return "{" +
                "requestId='$requestId'," +
                " phoneNumber='$phoneNumber'," +
                " brands=$brands," +
                " models=$models," +
                " generations=$generations," +
                " fromYear=$fromYear," +
                " toYear=$toYear," +
                " fromPrice=$fromPrice," +
                " fromPriceUSD=$fromPriceUSD," +
                " toPrice=$toPrice," +
                " toPriceUSD=$toPriceUSD," +
                " fromEngineVolume=$fromEngineVolume," +
                " toEngineVolume=$toEngineVolume," +
                " fromMileage=$fromMileage," +
                " toMileage=$toMileage," +
                " city=$city," +
                " engineTypes=$engineTypes," +
                " colors=$colors" +
                "}"
    }
}
