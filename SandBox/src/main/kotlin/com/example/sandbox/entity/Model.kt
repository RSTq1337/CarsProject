package com.example.sandbox.entity

import jakarta.persistence.*


@Entity
@Table(name = "MODEL")
data class Model(
    @Id
    @Column(name = "model_id")
    var modelId: Int = 0,

    var modelName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var generations: Set<Generation> = mutableSetOf(),
)
