package com.greatdayhr.support.feature.auth.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.greatdayhr.support.core.ResponseHandler
import com.greatdayhr.support.core.extension.get
import com.greatdayhr.support.core.extension.remove
import com.greatdayhr.support.core.extension.save
import com.greatdayhr.support.feature.auth.data.model.DATA
import com.greatdayhr.support.feature.auth.data.model.ResponseLogin

class LoginRepository(
    private val loginServices: LoginServices,
    private val responseHandler: ResponseHandler,
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) {

    /** Saas data **/
    fun saveSassData(data: DATA?) {
        val saasData = gson.toJson(data, DATA::class.java)
        sharedPreferences.save("SAAS", saasData)
    }

    fun getSass(): DATA? {
        val saasData = sharedPreferences.get("SAAS")
        if (saasData.isNullOrEmpty()) {
            return null
        }
        return gson.fromJson(saasData, DATA::class.java)
    }

    fun getBaseUrl(): String? {
        val data = getSass()
        if (!data?.goPathNew.isNullOrEmpty()) {
            return data?.goPathNew
        }
        return data?.gOPATH
    }

    fun isServiceV2(): Boolean {
        val data = getSass()
        if (!data?.goPathNew.isNullOrEmpty()) {
            return true
        }
        return false
    }

    /** Login data **/
    fun saveCredential(loginResponse: ResponseLogin) {
        val credentialData = gson.toJson(loginResponse, ResponseLogin::class.java)
        sharedPreferences.save("token", loginResponse.id)
        sharedPreferences.save("CREDENTIAL", credentialData)
    }

    fun getCredential(): ResponseLogin? {
        val credentialData = sharedPreferences.get("CREDENTIAL")
        if (credentialData.isNullOrEmpty()) {
            return null
        }
        return gson.fromJson(credentialData, ResponseLogin::class.java)
    }

    fun clearCredential() {
        sharedPreferences.remove("token")
        sharedPreferences.remove("CREDENTIAL")
    }

    fun isLogin(): Boolean {
        val token = sharedPreferences.get("token")
        if (token.isNullOrEmpty()) {
            return false
        }
        return true
    }
}