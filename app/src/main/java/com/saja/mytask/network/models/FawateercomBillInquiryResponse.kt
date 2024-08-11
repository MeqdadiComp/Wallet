package com.saja.mytask.network.models

data class FawateercomBillInquiryResponse(
    val a2AChannel: String? = null,
    val a2APWD: String? = null,
    val a2AUserID: String? = null,
    val address: String? = null,
    val billerCode: String? = null,
    val billerName: String? = null,
    val billingNo: String? = null,
    val billNo: String? = null,
    val bills: Bills? = null,
    val custID: String? = null,
    val custInfoFlag: String? = null,
    val dateFlag: String? = null,
    val eMail: String? = null,
    val endDt: String? = null,
    val errorCode: String? = null,
    val errorEDesc: String? = null,
    val id: String? = null,
    val idType: String? = null,
    val incPayments: String? = null,
    val inqRefNo: String? = null,
    val joebppsNo: String? = null,
    val key: String? = null,
    val name: String? = null,
    val nation: String? = null,
    val phone: String? = null,
    val proccess: Long? = null,
    val serviceType: String? = null,
    val startDt: String? = null
)

data class Bills(
    val wcBill: WcBill? = null
)

data class WcBill(
    val benAName: String? = null,
    val benEName: String? = null,
    val benNation: String? = null,
    val billNo: String? = null,
    val billStatus: String? = null,
    val custName: String? = null,
    val dueAmount: String? = null,
    val dueDate: String? = null,
    val feesAmt: String? = null,
    val feesOnBiller: String? = null,
    val freeText: String? = null,
    val hisBills: List<HisBill>? = null,
    val issueDate: String? = null,
    val lower: String? = null,
    val receivingCountry: String? = null,
    val senderAName: String? = null,
    val senderEName: String? = null,
    val senderID: String? = null,
    val senderIDType: String? = null,
    val senderNation: String? = null,
    val serviceType: String? = null,
    val transferReason: String? = null,
    val upper: String? = null
)

data class HisBill(
    val bankCode: String? = null,
    val dueAmount: String? = null,
    val joebppsTrx: String? = null,
    val paidAmt: Long? = null,
    val pmtStatus: String? = null,
    val processDate: String? = null
)