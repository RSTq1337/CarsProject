package com.parsem.parse.service.entity.base.av

import jakarta.persistence.*

@Entity
@Table(name = "AV_BRAND")
data class AvBrand(
    @Id
    @Column(name = "brand_id")
    var brandId: Int = 0,

    var brandName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER )
    var avModels: Set<AvModel> = mutableSetOf()
)
