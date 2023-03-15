package com.example.sandbox.entity.av

import jakarta.persistence.*

@Entity
@Table(name = "AV_BRAND")
data class AvBrand(
    @Id
    @Column(name = "brand_id")
    var brandId: Int = 0,

    var brandName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var avModels: Set<AvModel> = mutableSetOf()
)