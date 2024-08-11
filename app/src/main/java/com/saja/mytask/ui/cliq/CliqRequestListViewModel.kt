package com.saja.mytask.ui.cliq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iebayirli.recyclerviewwithdatabinding.internal.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CliqRequestListViewModel  @Inject constructor() : ViewModel(), CliQRequestListener {

    private val _requestsList = MutableLiveData<List<CliqRequestModel>>()
    val requestsList: LiveData<List<CliqRequestModel>> = _requestsList

    private val _showProgressBar = MutableLiveData(false)
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    val showToast = MutableLiveData<Event<CliqRequestModel>>()

    init {
        submitMovieList()
    }

    private fun submitMovieList() {
        viewModelScope.launch {
            fetchRequests()
                .onStart {
                    _showProgressBar.postValue(true)
                }.catch { err ->
                    _showProgressBar.postValue(false)
                }
                .collect { list ->
                    _showProgressBar.postValue(false)
                    _requestsList.value = list
                }
        }
    }


    object ConstRequestsData {

        var requestsList = mutableListOf<CliqRequestModel>(
            CliqRequestModel(
                recipientName = "John Doe",
                senderName = "Jane Smith",
                amount = "100.00",
                currency = "JOD",
                status = "Pending"
            ),
            CliqRequestModel(
                recipientName = "Nasser",
                senderName = "Ali",
                amount = "10.00",
                currency = "JOD",
                status = "Pending"
            ),
            CliqRequestModel(
                recipientName = "Raed",
                senderName = "Fahad",
                amount = "100.00",
                currency = "JOD",
                status = "Pending"
            ),
            CliqRequestModel(
                recipientName = "Ghazal",
                senderName = "Taha",
                amount = "1.00",
                currency = "JOD",
                status = "Pending"
            ),
            CliqRequestModel(
                recipientName = "Khalid",
                senderName = "Wael",
                amount = "75.00",
                currency = "JOD",
                status = "Pending"
            )
        )
    }

    private fun fetchRequests() = flow<List<CliqRequestModel>> {
        delay(700)
        emit(ConstRequestsData.requestsList)
    }.flowOn(Dispatchers.IO)

    override fun onAcceptClicked(request: CliqRequestModel) {
        TODO("Not yet implemented")
    }

    override fun onRejectClicked(request: CliqRequestModel) {
        TODO("Not yet implemented")
    }

    override fun onDetailsClicked(request: CliqRequestModel) {
        TODO("Not yet implemented")
    }

//    override fun onMovieClicked(movie: Movie) {
//        showToast.value = Event(movie)
//    }
//
//    override fun onFavouriteClicked(movie: Movie) {
//        val ind = ConstMovieData.movieList.indexOf(movie)
//        ConstMovieData.movieList[ind].favourite = !ConstMovieData.movieList[ind].favourite
//        submitMovieList()
//    }
}
