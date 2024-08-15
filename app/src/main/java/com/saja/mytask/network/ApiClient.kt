package com.saja.mytask.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
            .newBuilder()
            .build()
        return chain.proceed(request)
    }
}
var  interceptor =  HttpLoggingInterceptor()
object ApiClient {

    private const val BASE_URL = "http://10.10.90.175/MFP.NET/JIBMiddleware/MobileBanking.asmx/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor)
        .addInterceptor(interceptor)
        .build()


    fun create(): ServiceApi {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ServiceApi::class.java)
    }
}