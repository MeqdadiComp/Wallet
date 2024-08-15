package com.saja.mytask.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saja.mytask.network.models.LoginResponse
import com.saja.mytask.network.models.ResponseBaseModel
import com.saja.mytask.repository.LoginRepository
import com.saja.mytask.repository.MainRepository
import com.saja.mytask.utils.DataState
import dagger.assisted.Assisted
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//@Assisted
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val loginRepository: LoginRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<String>> = MutableLiveData()
    private val _loginDataState: MutableLiveData<DataState<ResponseBaseModel<LoginResponse>>> =
        MutableLiveData()

    val dataState: LiveData<DataState<String>>
        get() = _dataState

    val loginDataState: LiveData<DataState<ResponseBaseModel<LoginResponse>>>
        get() = _loginDataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetJwtTokenEvent -> {
                    mainRepository.generateJwtToken().onEach { dataState ->
                            _dataState.value = dataState
                        }.launchIn(viewModelScope)
                }

                is MainStateEvent.LoginEvent -> {
                    loginRepository.login().onEach { loginDataState ->
                            _loginDataState.value = loginDataState
                        }.launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    // No action
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetJwtTokenEvent : MainStateEvent()
    object LoginEvent : MainStateEvent()
    object None : MainStateEvent()
}