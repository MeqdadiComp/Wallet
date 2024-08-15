package com.saja.mytask.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor() {

    private val _state: MutableStateFlow<AuthManagerState> = MutableStateFlow(AuthManagerState.NotLoggedIn)
    val state: StateFlow<AuthManagerState> = _state.asStateFlow()

//    suspend fun logIn() {
//        _state.value = AuthManagerState.LogggingIn
//        delay(500)
//        _state.value = AuthManagerState.LoggedIn(user = User(firstName = "John", lastName = "Doe"))
//    }


//    @HiltViewModel
//    class ExampleViewModel @Inject constructor(private val authManager: AuthManager): ViewModel() {
//
//        val loggedInUserName: StateFlow<String?> = authManager.state.map {
//            when(it) {
//                is AuthManagerState.LoggedIn -> it.user.firstName
//                AuthManagerState.LogggingIn -> null
//                AuthManagerState.NotLoggedIn -> null
//            }
//        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)


    }