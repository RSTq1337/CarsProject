package com.parsem.webprovider.dto.entity

import javax.persistence.*

@Table(name = "ModelCharacteristic")
@Entity
class ModelCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "webModel", nullable = false)
    open var name: String? = null

    @Column(name = "onlinerModel", nullable = false)
    open var onlinerName: String? = null

    @Column(name = "avModel", nullable = true)
    open var avName: String? = null
}