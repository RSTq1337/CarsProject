package com.parsem.parse.service.repository

import com.parsem.parse.service.dto.entity.Generation
import org.springframework.data.jpa.repository.JpaRepository

interface GenerationRepository: JpaRepository<Generation, Int> {
}