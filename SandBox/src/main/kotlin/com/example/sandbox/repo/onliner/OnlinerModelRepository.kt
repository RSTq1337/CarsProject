package com.example.sandbox.repo.onliner

import com.example.sandbox.entity.onliner.OnlinerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OnlinerModelRepository: JpaRepository<OnlinerModel, Int> {
}