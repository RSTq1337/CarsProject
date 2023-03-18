package com.parsem.webprovider.entity

import com.parsem.webprovider.dto.RequestStatusEnum
import javax.persistence.*

@Entity
@Table(name = "REQUEST_STATUS")
data class RequestStatus(
    @Id
    @Column(name = "request_id")
    var requestId: String = "",

    @Enumerated(EnumType.STRING)
    var status: RequestStatusEnum
)
