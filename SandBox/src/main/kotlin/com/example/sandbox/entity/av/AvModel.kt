package com.example.sandbox.entity.av

import jakarta.persistence.*

@Entity
@Table(name = "AV_MODEL")
data class AvModel(
    @Id
    @Column(name = "model_id")
    var modelId: Int = 0,

    var modelName: String = "",
    var modelUrl: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var avGenerations: Set<AvGeneration> = mutableSetOf(),
)
