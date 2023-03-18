package com.parsem.parse.service.entity.base.av

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "AV_FIX_BRAND")
data class AvFixBrand(
    @Id
    var brandNameSource: String = "",
    var brandNameCorrect: String = ""
)
