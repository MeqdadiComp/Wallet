package com.saja.mytask.network.models

open class ResponseBaseModel<T>(val ResponseStatus : String, val ResponseCode : Int, val result : T,val ErrorDescEn: String,val ErrorDescAr: String,val ErrorCode : String)