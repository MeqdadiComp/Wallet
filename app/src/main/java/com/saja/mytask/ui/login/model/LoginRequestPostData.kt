package com.saja.mytask.ui.login.model

import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @SerializedName("CIF") val cif: String
)

data class TokenResponse(
    @SerializedName("response") val response: TokenResponseBody
)

data class TokenResponseBody(

    @SerializedName("token") val token: String,

    )
