package com.example.sandbox.repo.onliner

import com.example.sandbox.entity.onliner.OnlinerGeneration
import org.springframework.data.jpa.repository.JpaRepository

interface OnlinerGenerationRepository: JpaRepository<OnlinerGeneration, Int> {
}