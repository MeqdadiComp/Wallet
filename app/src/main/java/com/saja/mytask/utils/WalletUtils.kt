package com.saja.mytask.utils

import PreferenceHelper.set
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext

class WalletUtils {
    companion object {
        fun getAuthorizedHeaderMap(@ApplicationContext appContext: Context): Map<String, String> {
            val headerMap = mutableMapOf<String, String>()
            headerMap["language"] = "en"
            headerMap["deviceId"] = "123456789"
            headerMap["deviceType"] = "iPhone9.1"
            headerMap["osVersion"] = "1.0"
            headerMap["appVersion"] = "1.0"
            headerMap["Authorization"] = "Bearer ${getAuthorizationJWTToken(appContext)}"
            return headerMap
        }

        fun saveAuthorizationJWTToken(
            @ApplicationContext appContext: Context,
            accessToken: String
        ) {
            // Storing an access token in SharedPreferences
            PreferenceHelper.defaultPrefs(appContext)["jwt_token"] = accessToken
        }

        private fun getAuthorizationJWTToken(
            @ApplicationContext appContext: Context
        ): String? {
            // Retrieving an access token from SharedPreferences
            return PreferenceHelper.defaultPrefs(appContext).getString("jwt_token", "")
        }
    }
}