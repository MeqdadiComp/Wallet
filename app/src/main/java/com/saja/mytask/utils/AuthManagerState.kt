package com.saja.mytask.utils

import com.saja.mytask.network.models.User

sealed class AuthManagerState {
    object NotLoggedIn: AuthManagerState()
    object LogggingIn: AuthManagerState()
    data class LoggedIn(
        val user: User
    ): AuthManagerState()
}