package com.saja.mytask.network.models

data class FawateercomServiceTypeResponse (
        val aDesc: String?,
        val aLabel: String?,
        val arImg: String?,
        val arLblShortDesc: String?,
        val arShortDesc: String?,
        val billingNoFlag: String?,
        val billType: String?,
        val code: String?,
        val denoFlag: String?,
        val denominations: Denominations?,
        val eDesc: String?,
        val eLabel: String?,
        val enImg: String?,
        val enLblShortDesc: String?,
        val enShortDesc: String?,
        val mArImg: String?,
        val mArMsg: String?,
        val mEnImg: String?,
        val mEnMsg: String?,
        val postpaid: String?,
        val regex: String?
    )

    data class Denominations (
        val wcDeno: List<WcDeno>?
    )

    data class WcDeno (
        val aDesc: String?,
        val arShortDesc: String?,
        val code: String?,
        val eDesc: String?,
        val enShortDesc: String?,
        val type: String?
    )