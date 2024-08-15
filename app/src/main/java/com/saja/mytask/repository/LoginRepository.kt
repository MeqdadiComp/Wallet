package com.saja.mytask.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.saja.mytask.network.ServiceApi
import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.network.models.TokenResultClass
import com.saja.mytask.utils.Constant
import com.saja.mytask.utils.Constant.TEST_USER_NAME
import com.saja.mytask.utils.DataState
import com.saja.mytask.utils.WalletUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse


class LoginRepository(
    private val serviceApi: ServiceApi,
    private val applicationContext: Context
) {

    //         context: Context, callback: (Context) -> Unit
    suspend fun login(
        ) : Flow<DataState<ResponseBaseModel<LoginResponse>>> = flow {

        emit(DataState.Loading)

        val bodyMap = mutableMapOf<String, String>()
        bodyMap["userName"] = Constant.TEST_USER_NAME
        bodyMap["password"] = Constant.TEST_USER_PASSWORD
        bodyMap["userKey"] = ""
        bodyMap["userHash"] = ""
        try {
            val response = serviceApi.login(WalletUtils.getAuthorizedHeaderMap(applicationContext),bodyMap).awaitResponse()
            if (response.isSuccessful) {
                Log.i("LOGIN_REPO", "API call successful")
//                    val post = response.body()

                // Handle the retrieved post data
                response.body()?.let {
                    Log.i("LOGIN_REPO", "login API Success")
                    emit(DataState.Success(it))
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



//            val loginCall: Call<ResponseBaseModel<LoginResponse>> = serviceApi.login(
//                WalletUtils.getAuthorizedHeaderMap(applicationContext),
//                bodyMap
//            )
//            loginCall.enqueue(object : Callback<ResponseBaseModel<LoginResponse>> {
//                override fun onResponse(
//                    call: Call<ResponseBaseModel<LoginResponse>>,
//                    response: Response<ResponseBaseModel<LoginResponse>>
//                ) {
//                    if (response.isSuccessful) {
//                        val tokenResponse = response.body()
//                        val token = tokenResponse?.result?.result
//                        if (token != null) {
//                            callback.invoke(token)
//                            // Save the token for future use, maybe in shared preferences or in a global variable
//                        }
//                    }
//                    else {
//                        // Handle unsuccessful response
//                        Toast.makeText(
//                            applicationContext,
//                            "Failed to login: ${response.errorBody()?.string()}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//                override fun onFailure(
//                    call: Call<ResponseBaseModel<LoginResponse>>, t: Throwable
//                ) {
//                    // Handle failure
//                    Toast.makeText(
//                        applicationContext, "Error fetching token: ${t.message}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            })
//        }
//    }
}