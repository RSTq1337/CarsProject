package com.parsem.parse.service.entity.base.av

import jakarta.persistence.*

@Entity
@Table(name = "AV_GENERATION")
data class AvGeneration(
    @Id
    @Column(name = "generation_id")
    var generationId: Int = 0,

    var generationName: String = "",
)
