package com.example.sandbox.repo.av.db

import com.example.sandbox.entity.av.AvGeneration
import org.springframework.data.jpa.repository.JpaRepository

interface AvGenerationRepository: JpaRepository<AvGeneration, Int> {
}