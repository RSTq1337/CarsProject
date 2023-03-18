package com.parsem.parse.service.repository.onliner

import com.parsem.parse.service.entity.base.onliner.OnlinerGeneration
import org.springframework.data.jpa.repository.JpaRepository

interface OnlinerGenerationRepository: JpaRepository<OnlinerGeneration, Int> {
    fun findAllByGenerationName(generation: String): OnlinerGeneration
}