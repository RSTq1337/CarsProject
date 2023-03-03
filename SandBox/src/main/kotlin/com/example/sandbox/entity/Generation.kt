package com.example.sandbox.entity

import jakarta.persistence.*

@Entity
@Table(name = "GENERATION")
data class Generation(
    @Id
    @Column(name = "generation_id")
    var generationId: Int = 0,

    var generationName: String = "",
)
