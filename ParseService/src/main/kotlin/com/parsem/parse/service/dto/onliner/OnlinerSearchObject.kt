package com.parsem.parse.service.dto.onliner

data class OnlinerSearchObject(
    val brands: Set<Int>,
    val models: Set<Int>,
    val generations: Set<Int>
)
