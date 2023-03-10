package com.parsem.parse.service.repository

import com.parsem.parse.service.dto.CarDataFromOnliner
import com.parsem.parse.service.dto.entity.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository: JpaRepository<Car, String> {
}