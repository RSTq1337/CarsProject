package com.example.sandbox.repo

import com.example.sandbox.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BrandRepository: JpaRepository<Brand, Int> {
}