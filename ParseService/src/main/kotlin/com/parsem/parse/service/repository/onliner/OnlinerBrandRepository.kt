package com.parsem.parse.service.repository.onliner

import com.parsem.parse.service.entity.base.onliner.OnlinerBrand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OnlinerBrandRepository: JpaRepository<OnlinerBrand, Int> {
    fun findAllByBrandName(brandName: String): OnlinerBrand
}