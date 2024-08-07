package com.saja.mytask.network.models

data class LookupResponse(
    val id : Int,
    val typeId: Int,
    val nameAr: String,
    val nameEn: String,
    val isDeleted: Boolean
)