package com.saja.mytask.ui.cliq

interface CliQRequestListAdapterItem : ListAdapterItemBase {
    val recipientName: String
    val senderName: String
    val amount: String
    val currency: String
    val status: String
}