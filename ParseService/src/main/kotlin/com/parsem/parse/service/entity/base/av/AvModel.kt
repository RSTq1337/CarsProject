package com.parsem.parse.service.entity.base.av

import jakarta.persistence.*

@Entity
@Table(name = "AV_MODEL")
data class AvModel(
    @Id
    @Column(name = "model_id")
    var modelId: Int = 0,

    var modelName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER )
    var avGenerations: Set<AvGeneration> = mutableSetOf(),
) {
}
