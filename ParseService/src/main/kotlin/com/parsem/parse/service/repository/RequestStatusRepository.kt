package com.parsem.parse.service.repository

import com.parsem.parse.service.entity.RequestStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestStatusRepository: JpaRepository<RequestStatus, Int> {
}