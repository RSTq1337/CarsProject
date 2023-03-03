package com.parsem.webprovider.dto.entity

import javax.persistence.*

@Table(name = "BrandCharacteristic")
@Entity
open class BrandCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "webName", nullable = false)
    open var name: String? = null

    @Column(name = "onlinerName", nullable = false)
    open var onlinerName: String? = null

    @Column(name = "avName", nullable = true)
    open var avName: String? = null

}