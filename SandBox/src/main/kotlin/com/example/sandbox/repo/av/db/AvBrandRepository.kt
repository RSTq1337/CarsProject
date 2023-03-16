package com.example.sandbox.repo.av.db

import com.example.sandbox.entity.av.AvBrand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvBrandRepository: JpaRepository<AvBrand, Int> {
}