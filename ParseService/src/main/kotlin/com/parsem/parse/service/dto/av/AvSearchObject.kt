package com.parsem.parse.service.dto.av

data class AvSearchObject(
    val brands: Set<Int>,
    val models: Set<Int>,
    val generations: Set<Int>
)