package com.greatdayhr.support.feature.auth.data.model
import com.google.gson.annotations.SerializedName


data class ResponseForgotPassword(
    @SerializedName("result")
    val result: Boolean
)
