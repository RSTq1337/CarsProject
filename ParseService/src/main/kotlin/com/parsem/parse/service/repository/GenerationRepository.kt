package com.parsem.parse.service.repository

import com.parsem.parse.service.dto.entity.base.onliner.OnlinerGeneration
import org.springframework.data.jpa.repository.JpaRepository

interface GenerationRepository: JpaRepository<OnlinerGeneration, Int> {
}