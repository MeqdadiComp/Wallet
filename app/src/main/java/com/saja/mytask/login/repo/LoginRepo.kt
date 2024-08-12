package com.saja.mytask.login.repo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.saja.mytask.login.model.TokenRequest
import com.saja.mytask.login.model.TokenResponse
import com.saja.mytask.network.ApiClient
import com.saja.mytask.network.ApiService
import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.network.models.TokenResultClass
import com.saja.mytask.ui.DashboardActivity
import com.saja.mytask.utils.Constant.TEST_USER_NAME
import com.saja.mytask.utils.WalletUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo {
    companion object {
//fun main() {
//    val apiService = ApiClient.create()
//
//    val request = TokenRequest("5E2753718B1E99454A02C3633823B3D9")
//    val call = apiService.getToken(request)
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

        fun generateJwtToken(
            context: Context, apiService: ApiService, callback: (Context) -> Unit
        ) {
            val bodyMap = mutableMapOf<String, String>()
            bodyMap["mobileNumber"] = TEST_USER_NAME
            val call = apiService.generateJwtToken(bodyMap)
            call.enqueue(object : Callback<ResponseBaseModel<String>> {
                override fun onResponse(
                    call: Call<ResponseBaseModel<String>>,
                    response: Response<ResponseBaseModel<String>>
                ) {
                    if (response.isSuccessful) {
                        Log.i("API Success", "API call successful")
//                    val post = response.body()
                        CoroutineScope(Dispatchers.IO).launch {
                            // Handle the retrieved post data
                            response.body()?.let {
                                Log.i("LOGIN_REPO", "JWT token : ${it.result}")
                                // Save the JWT token for future use
                                WalletUtils.saveAuthorizationJWTToken(context,it.result)
                            }
                            callback.invoke(context)
                        }

                    } else {
                        // Handle error
                    }
                }

                override fun onFailure(call: Call<ResponseBaseModel<String>>, t: Throwable) {
                    // Handle failure
                    Log.e("API Error", "API call failed")
                }
            })
        }

        fun login(
            applicationContext: Context,
            apiService: ApiService,
            bodyMap: Map<String, String>,
            callback: (TokenResultClass) -> Unit
        ) {
            val loginCall: Call<ResponseBaseModel<LoginResponse>> = apiService.login(
                WalletUtils.getAuthorizedHeaderMap(applicationContext),
                bodyMap
            )
            loginCall.enqueue(object : Callback<ResponseBaseModel<LoginResponse>> {
                override fun onResponse(
                    call: Call<ResponseBaseModel<LoginResponse>>,
                    response: Response<ResponseBaseModel<LoginResponse>>
                ) {
                    if (response.isSuccessful) {
                        val tokenResponse = response.body()
                        val token = tokenResponse?.result?.result
                        if (token != null) {
                            callback.invoke(token)
                            // Save the token for future use, maybe in shared preferences or in a global variable
                        }
                    }
                    else {
                        // Handle unsuccessful response
                        Toast.makeText(
                            applicationContext,
                            "Failed to login: ${response.errorBody()?.string()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<ResponseBaseModel<LoginResponse>>, t: Throwable
                ) {
                    // Handle failure
                    Toast.makeText(
                        applicationContext, "Error fetching token: ${t.message}", Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}