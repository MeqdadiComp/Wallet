package com.saja.mytask.ui.login.model

data class LoginResponseData(
    var response: LoginSubResponse,
)


data class LoginSubResponse(
//    @SerializedName("ReferenceNumber") for future use
    var token:String
)
