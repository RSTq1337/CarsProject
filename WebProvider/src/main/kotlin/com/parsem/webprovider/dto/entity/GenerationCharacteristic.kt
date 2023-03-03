package com.parsem.webprovider.dto.entity

import javax.persistence.*

@Table(name = "GenerationCharacteristic")
@Entity
open class GenerationCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "webGeneration", nullable = false)
    open var name: String? = null

    @Column(name = "onlinerGeneration", nullable = false)
    open var onlinerName: String? = null

    @Column(name = "avGeneration", nullable = true)
    open var avName: String? = null
}