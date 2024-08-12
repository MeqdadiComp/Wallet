package com.saja.mytask.utils

import com.saja.mytask.network.ApiService
import com.saja.mytask.utils.Constant.WALLET_API_BASE_ADAPTER
import com.saja.mytask.utils.Constant.WALLET_API_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object APIServiceModule {
    @Named("APIService")
    @Provides
    fun provideBaseAPIService(): ApiService {
        val client = OkHttpClient()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder: OkHttpClient.Builder =
            client.newBuilder().addInterceptor(interceptor)


        return Retrofit.Builder().baseUrl("${WALLET_API_BASE_URL}/${ WALLET_API_BASE_ADAPTER}/")
            .addConverterFactory(GsonConverterFactory.create()).client(clientBuilder.build())
            .build()
            .create(ApiService::class.java)
    }
}
//
//// As a dependency of a constructor-injected class.
//class ExampleServiceImpl @Inject constructor(
//    @AuthInterceptorOkHttpClient private val okHttpClient: OkHttpClient
//) : ...
//
//// At field injection.
//@AndroidEntryPoint
//class ExampleActivity: AppCompatActivity() {
//
//    @AuthInterceptorOkHttpClient
//    @Inject lateinit var okHttpClient: OkHttpClient
//}