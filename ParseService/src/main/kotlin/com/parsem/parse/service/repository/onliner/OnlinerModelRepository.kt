package com.parsem.parse.service.repository.onliner

import com.parsem.parse.service.entity.base.onliner.OnlinerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OnlinerModelRepository: JpaRepository<OnlinerModel, Int> {
    fun findAllByModelName(modelName: String): OnlinerModel
}