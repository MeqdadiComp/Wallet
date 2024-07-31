package com.saja.mytask.network

import com.saja.mytask.login.model.TokenRequest
import com.saja.mytask.login.model.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers(
        "JIBMiddleWareKey: JIBP@ssw0rd",
        "scope: restrictedService",
        "Content-Type: application/json",
        "Authorization: Basic SklCTWlkZGxld2FyZTpKSUJNaWRkbGV3YXJlMjAyMQ=="
    )
    @POST("token")
    fun getToken(@Body request: TokenRequest): Call<TokenResponse>
}