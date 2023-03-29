package com.parsem.parse.service.repository.av

import com.parsem.parse.service.entity.base.av.AvBrand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvBrandRepository: JpaRepository<AvBrand, Int> {
    fun findAllByBrandName(brandName: String): AvBrand
}