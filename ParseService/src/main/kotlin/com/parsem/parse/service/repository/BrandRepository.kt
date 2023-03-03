package com.parsem.parse.service.repository

import com.parsem.parse.service.dto.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BrandRepository: JpaRepository<Brand, Int> {
}