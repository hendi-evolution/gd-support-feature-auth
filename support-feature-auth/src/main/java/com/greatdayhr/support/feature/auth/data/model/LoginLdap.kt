package com.greatdayhr.support.feature.auth.data.model
import com.google.gson.annotations.SerializedName

data class ResponseLoginLdap(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("mode")
    val mode: String
)

data class RequestLoginLdap(
    @SerializedName("ist")
    val ist: String
)