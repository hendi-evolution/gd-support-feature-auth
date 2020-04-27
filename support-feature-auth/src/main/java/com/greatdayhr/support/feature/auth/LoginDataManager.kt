package com.greatdayhr.support.feature.auth

import android.content.Context
import com.greatdayhr.support.core.di.DaggerCoreComponent
import com.greatdayhr.support.core.di.module.ContextModule
import com.greatdayhr.support.feature.auth.data.LoginRepository
import com.greatdayhr.support.feature.auth.data.model.DATA
import com.greatdayhr.support.feature.auth.data.model.ResponseLogin
import com.greatdayhr.support.feature.auth.di.DaggerFeatureLoginComponent
import javax.inject.Inject

/**
 * LoginManagerData
 * */
class LoginDataManager(applicationContext: Context) {
    @Inject
    lateinit var loginRepository: LoginRepository

    init {
        val coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        DaggerFeatureLoginComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    fun getSaas(): DATA? = loginRepository.getSass()
    fun isLogin(): Boolean = loginRepository.isLogin()
    fun getCredential(): ResponseLogin? = loginRepository.getCredential()
    fun getBaseUrl(): String? = loginRepository.getBaseUrl()
}

/**
 * LoginManagerListener
 * */
interface LoginManagerListener {
    fun onLoginSuccess() = Unit
    fun onLogoutSuccess() = Unit
    fun onLogoutError(message: String) = Unit
}