package com.saja.mytask.network

import com.saja.mytask.network.models.FawateercomLookupResponse
import com.saja.mytask.network.models.ResponseBaseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface CliQApiService {
    @POST("GetCategory")
    fun getCategory(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomLookupResponse>>>
}