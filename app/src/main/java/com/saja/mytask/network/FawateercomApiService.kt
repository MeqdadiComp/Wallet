package com.saja.mytask.network


import com.saja.mytask.network.models.FawateercomBillInquiryResponse
import com.saja.mytask.network.models.FawateercomBillPaymentResponse
import com.saja.mytask.network.models.FawateercomCustomerSavedBillResponse
import com.saja.mytask.network.models.FawateercomLookupResponse
import com.saja.mytask.network.models.FawateercomPrePaidValidationResponse
import com.saja.mytask.network.models.FawateercomServiceTypeResponse
import com.saja.mytask.network.models.ResponseBaseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface FawateercomApiService {
    @POST("GetCategory")
    fun getCategory(@HeaderMap headers: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomLookupResponse>>>

    @POST("GetBillersList")
    fun getBillersList(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomLookupResponse>>>

    @POST("GetServiceType")
    fun getServiceType(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomServiceTypeResponse>>>

    @POST("BillInquery")
    fun billInquiry(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<FawateercomBillInquiryResponse>>

    @POST("BillPayment")
    fun billPayment(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<FawateercomBillPaymentResponse>>

    @POST("PrepaidValidation")
    fun prepaidValidation(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomPrePaidValidationResponse>>>

    @POST("GetCustomerSavedBills")
    fun getCustomerSavedBills(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<ArrayList<FawateercomCustomerSavedBillResponse>>>

    @POST("AddBill")
    fun addBill(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<Boolean>>

    @POST("RemoveBill")
    fun removeBill(@HeaderMap headers: Map<String, String>,@Body post: Map<String, String>): Call<ResponseBaseModel<Boolean>>

}