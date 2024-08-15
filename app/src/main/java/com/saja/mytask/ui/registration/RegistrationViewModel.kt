package com.saja.mytask.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saja.mytask.network.ServiceApi
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val serviceApi: ServiceApi
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is registration Fragment"
    }
    val text: LiveData<String> = _text
}