package com.parsem.parse.service.entity.base.onliner

import jakarta.persistence.*

@Entity
@Table(name = "ONLINER_BRAND")
data class OnlinerBrand(
    @Id
    @Column(name = "brand_id")
    var brandId: Int = 0,

    var brandName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var onlinerModels: Set<OnlinerModel> = mutableSetOf()
)
