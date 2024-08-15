package com.saja.mytask.network

import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.LookupResponse
import com.saja.mytask.network.models.RegistrationResponseModel
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.network.models.UploadImageResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ServiceApi {

//    @Headers(
//        "JIBMiddleWareKey: JIBP@ssw0rd",
//        "scope: restrictedService",
//        "Content-Type: application/json",
//        "Authorization: Basic SklCTWlkZGxld2FyZTpKSUJNaWRkbGV3YXJlMjAyMQ=="
//    )
//    @POST("token")
//    fun getToken(@Body request: TokenRequest): Call<TokenResponse>

    @POST("Login")
    fun login(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<LoginResponse>>

    @POST("GetLookupByTypeId")
    fun getLookupByTypeId(@HeaderMap headers: Map<String, String>,@Body post: String): Call<ArrayList<LookupResponse>>

    @POST("GenerateJwtToken")
    fun generateJwtToken(@Body post: Map<String, String>): Call<ResponseBaseModel<String>>

    //    @Headers("\"language:1\"\"deviceId:123456789\"\"deviceType:iPhone9.1\"\"osVersion:1.0\"\"appVersion:1.0\"\"Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6InRva2VuV2FsbGV0IiwibmJmIjoxNzIxMjE5NDY5LCJleHAiOjE3MjEyMTk3NjksImlhdCI6MTcyMTIxOTQ2OSwiaXNzIjoieW91cl9pc3N1ZXJfaGVyZSIsImF1ZCI6InlvdXJfYXVkaWVuY2VfaGVyZSJ9.hdvYWw1J-a7gxMM5y5GGZrEOyJB042TXhlX-D7zL1cQ\"")
    @POST("RegisterStep1")
    fun registerStep1(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<RegistrationResponseModel>

    @POST("SendOTP")
    fun sendOTP(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<String>>

    @POST("ValidOTP")
    fun validateOTP(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<String>>

    @POST("Create")
    fun createUser(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<RegistrationResponseModel>

    @POST("UploadImage")
    fun uploadImage(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<UploadImageResponseModel>

}