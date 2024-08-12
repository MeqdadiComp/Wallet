package com.saja.mytask.network.models

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("Result")
    val result: TokenResultClass? = null,
    val id: Long? = null,
    val status: Long? = null,
    val isCanceled: Boolean? = null,
    val isCompleted: Boolean? = null,
    val isCompletedSuccessfully: Boolean? = null,
    val creationOptions: Long? = null,
    val isFaulted: Boolean? = null
)

data class TokenResultClass (
    val responseStatus: String? = null,
    val user: User? = null
)

data class User (
    val cif: String? = null,
    val touchDeviceID: String? = null,
    val cpFlag: String? = null,
    val preferredlanguage: String? = null,
    val status: String? = null,
    val tcFlag: String? = null,
    val temppwdgentime: String? = null,
    val uid: String? = null,
    val wrongKeyAttempts: String? = null,
    val nationalityDesc: String? = null,
    val poBox: String? = null,
    val documentTypeDesc: String? = null,
    val token: String? = null,
    val tokenStatus: String? = null,
    val userHash: String? = null,
    val touchID: String? = null,
    val touchIDStatus: String? = null,
    val userKey: String? = null,
    val deviceID: String? = null,
    val jomopayReg: String? = null,
    val isAdmin: Boolean? = null,
    val flFlag: String? = null,
    val tcFlagDate: String? = null,
    val cpFlagDate: String? = null,
    val flFlagDate: String? = null,
    val forgetCredentialsLockedStatus: Boolean? = null,
    val changeAliasNameJomopay: Boolean? = null,
    val lastSuccessLogin: String? = null,
    val cliQCustomerReg: String? = null,
    val cliQAccountReg: String? = null,
    val cliQAliasReg: String? = null,
    val isBlackList: Boolean? = null,
    val onLineReqstration: Boolean? = null,
    val loyaltyFlag: Boolean? = null,
    val ibanConfirmation: Boolean? = null,
    val additionalAccount: String? = null,
    val chequeFlag: Boolean? = null,
    val crifFlag: Boolean? = null,
    val institution: String? = null,
    val tokenFlag: Boolean? = null,
    val touchFlag: Boolean? = null,
    val messageAlertFlag: Boolean? = null,
    val ratingFlag: Boolean? = null,
    val isInterestedFinanceRequest: Boolean? = null,
    val registeredDevice: Boolean? = null,
    val isLastLoginLimit: Boolean? = null,
    val cbjOtpFlag: Boolean? = null,
    val showPromotionFlag: Boolean? = null,
    val trustedDeviceCount: Long? = null,
    val trustedDeviceCountMobile: Long? = null
)
