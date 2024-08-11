package com.saja.mytask.ui.cliq

data class CliqRequestModel(val recipientName: String,
                            val senderName: String,
                            val amount: String,
                            val currency: String,
                            val status: String) : ListAdapterItemBase{

}