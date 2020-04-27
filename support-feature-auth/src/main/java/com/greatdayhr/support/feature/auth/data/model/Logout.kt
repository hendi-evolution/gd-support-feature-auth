package com.greatdayhr.support.feature.auth.data.model

import com.google.gson.annotations.SerializedName

data class Logout(
    @SerializedName("error")
    val error: Error
)

data class Error(
    @SerializedName("message")
    val message: String
)