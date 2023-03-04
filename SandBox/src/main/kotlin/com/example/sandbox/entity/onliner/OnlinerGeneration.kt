package com.example.sandbox.entity.onliner

import jakarta.persistence.*

@Entity
@Table(name = "ONLINER_GENERATION")
data class OnlinerGeneration(
    @Id
    @Column(name = "generation_id")
    var generationId: Int = 0,

    var generationName: String = "",
)
