package com.example.sandbox.repo.onliner.db

import com.example.sandbox.entity.onliner.OnlinerGeneration
import org.springframework.data.jpa.repository.JpaRepository

interface OnlinerGenerationRepository: JpaRepository<OnlinerGeneration, Int> {
}