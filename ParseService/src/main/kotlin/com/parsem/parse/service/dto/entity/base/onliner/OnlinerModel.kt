package com.parsem.parse.service.dto.entity.base.onliner

import jakarta.persistence.*

@Entity
@Table(name = "MODEL")
data class OnlinerModel(
    @Id
    @Column(name = "model_id")
    var modelId: Int = 0,

    var modelName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var onlinerGenerations: Set<OnlinerGeneration> = mutableSetOf(),
)
