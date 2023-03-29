package com.parsem.parse.service.repository.av

import com.parsem.parse.service.entity.base.av.AvGeneration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvGenerationRepository: JpaRepository<AvGeneration, Int> {
}