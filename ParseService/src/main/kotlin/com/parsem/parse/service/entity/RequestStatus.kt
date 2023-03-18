package com.parsem.parse.service.entity

import com.parsem.parse.service.util.RequestStatusEnum
import jakarta.persistence.*

@Entity
@Table(name = "REQUEST_STATUS")
data class RequestStatus(
    @Id
    @Column(name = "request_id")
    var requestId: String = "",

    @Enumerated(EnumType.STRING)
    var status: RequestStatusEnum
)
