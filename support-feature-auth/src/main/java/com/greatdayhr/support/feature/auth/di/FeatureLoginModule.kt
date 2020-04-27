package com.greatdayhr.support.feature.auth.di

import android.content.SharedPreferences
import com.google.gson.Gson
import com.greatdayhr.support.core.ResponseHandler
import com.greatdayhr.support.core.di.scope.FeatureScope
import com.greatdayhr.support.feature.auth.data.LoginRepository
import com.greatdayhr.support.feature.auth.data.LoginServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class FeatureLoginModule {
    @Provides
    @FeatureScope
    fun getGson(): Gson = Gson()

    @Provides
    @FeatureScope
    fun apiService(retrofit: Retrofit): LoginServices {
        return retrofit.create(LoginServices::class.java)
    }

    @Provides
    @FeatureScope
    fun loginRepository(
        loginServices: LoginServices,
        responseHandler: ResponseHandler,
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): LoginRepository {
        return LoginRepository(loginServices, responseHandler, sharedPreferences, gson)
    }
}