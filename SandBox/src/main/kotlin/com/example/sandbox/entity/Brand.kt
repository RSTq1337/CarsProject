package com.example.sandbox.entity

import jakarta.persistence.*

@Entity
@Table(name = "BRAND")
data class Brand(
    @Id
    @Column(name = "brand_id")
    var brandId: Int = 0,

    var brandName: String = "",

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var models: Set<Model> = mutableSetOf()
)
