package com.parsem.parse.service.repository.av

import com.parsem.parse.service.entity.base.av.AvModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvModelRepository: JpaRepository<AvModel, Int> {
    fun findAllByModelName(modelName: String): List<AvModel>
}