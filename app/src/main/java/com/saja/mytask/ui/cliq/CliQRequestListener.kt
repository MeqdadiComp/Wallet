package com.saja.mytask.ui.cliq

interface CliQRequestListener {
    fun onAcceptClicked(request: CliqRequestModel)
    fun onRejectClicked(request: CliqRequestModel)
    fun onDetailsClicked(request: CliqRequestModel)
}