package com.saja.mytask.login.repo

import com.saja.mytask.login.model.TokenRequest
import com.saja.mytask.login.model.TokenResponse
import com.saja.mytask.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    val apiService = ApiClient.create()

    val request = TokenRequest("5E2753718B1E99454A02C3633823B3D9")
    val call = apiService.getToken(request)

    call.enqueue(object : Callback<TokenResponse> {
        override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
            if (response.isSuccessful) {
                val tokenResponse = response.body()
                println("Token: ${tokenResponse?.response?.token}")
            } else {
                println("Failed to get token: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
            println("Error fetching token: ${t.message}")
        }
    })
}
