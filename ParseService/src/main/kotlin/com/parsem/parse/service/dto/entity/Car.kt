package com.parsem.parse.service.dto.entity

import jakarta.persistence.*

@Entity
@Table(name = "CAR")
class Car(
    @Id
    @Column(name = "authorId")
    var authorId: String = "",

    var title: String = "",
    var brand: String = "",
    var model: String = "",
    var generation: String = "",
    var transmission: String = "",
    var odometer: String = "",
    var year: String = "",
    var color: String = "",
    var bodyType: String = "",
    var state: String = "",
    var driveTrain: String = "",
    var modification: String? = "",
    var engineType: String? = "",
    var engineCapacity: String? = "",
    var engineTorque: String? = "",
    var enginePower: String? = "",
    @ElementCollection
    var sellerNumber: List<String>? = mutableListOf(),
    var priceUSD: String = "",
    var priceBYN: String = "",
    @ElementCollection
    var imagesOG: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images1900: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images800: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images600: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images380: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images100: Set<String> = mutableSetOf<String>(),
    @ElementCollection
    var images80: Set<String> = mutableSetOf<String>(),
    var created: String = "",
    var url: String = "",

    )
