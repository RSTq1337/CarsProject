package com.parsem.parse.service.entity.base.onliner

import jakarta.persistence.*

@Entity
@Table(name = "ONLINER_MODEL")
data class OnlinerModel(
    @Id
    @Column(name = "model_id")
    var modelId: Int = 0,

    var modelName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER )
    var onlinerGenerations: Set<OnlinerGeneration> = mutableSetOf(),
)
