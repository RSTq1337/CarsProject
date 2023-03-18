package com.parsem.webprovider.repository

import com.parsem.webprovider.entity.RequestStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestStatusRepository: JpaRepository<RequestStatus, Int> {
}