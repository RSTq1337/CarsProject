package com.parsem.parse.service.sandbox

import com.parsem.parse.service.dto.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository: JpaRepository<Brand, Int>{
    fun findAllByBrandName(name: String?): List<Brand?>?
}