package com.saja.mytask.repository

import android.content.Context
import android.util.Log
import com.saja.mytask.network.ServiceApi
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.utils.Constant
import com.saja.mytask.utils.Constant.TEST_USER_NAME
import com.saja.mytask.utils.DataState
import com.saja.mytask.utils.WalletUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class MainRepository(
    private val serviceApi: ServiceApi
) {

    //         context: Context, callback: (Context) -> Unit
    suspend fun generateJwtToken(

    ): Flow<DataState<String>> = flow {

        emit(DataState.Loading)

        val bodyMap = mutableMapOf<String, String>()
        bodyMap["mobileNumber"] = TEST_USER_NAME
        try {
            val response = serviceApi.generateJwtToken(bodyMap).awaitResponse()
            if (response.isSuccessful) {
                Log.i("API Success", "API call successful")
//                    val post = response.body()

                // Handle the retrieved post data
                response.body()?.let {
                    Log.i("LOGIN_REPO", "JWT token : ${it.result}")
                    emit(DataState.Success(it.result))
                }
            } else {
                // Handle error
                if (!response.body()?.ResponseStatus?.lowercase().equals(Constant.SUCCESS)) {
                    emit(DataState.Error(Exception(response.body()?.ErrorDescEn ?: "")))
                } else {
                    emit(DataState.Error(Exception(response.errorBody()?.string() ?: "")))
                }
            }
        } catch (e: Exception) {
            emit(DataState.Error(e))
            Log.e("API Error", "API call failed")
        }
    }
}

//
//class MainRepository {
//    companion object {
//fun main() {
//    val serviceApi = ApiClient.create()
//
//    val request = TokenRequest("5E2753718B1E99454A02C3633823B3D9")
//    val call = serviceApi.getToken(request)
//
//    call.enqueue(object : Callback<TokenResponse> {
//        override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
//            if (response.isSuccessful) {
//                val tokenResponse = response.body()
//                println("Token: ${tokenResponse?.response?.token}")
//            } else {
//                println("Failed to get token: ${response.errorBody()?.string()}")
//            }
//        }
//
//        override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
//            println("Error fetching token: ${t.message}")
//        }
//    })
//}


//    }
//}