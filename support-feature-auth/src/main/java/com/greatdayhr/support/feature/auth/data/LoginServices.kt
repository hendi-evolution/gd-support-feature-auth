package com.greatdayhr.support.feature.auth.data

import com.greatdayhr.support.core.data.BaseResponseV2
import com.greatdayhr.support.feature.auth.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginServices {
    /**
     * Login
     */
    @GET("/sf6svc/SFCSunFish.cfm")
    suspend fun preLogin(
        @Query("PROVIDER") PROVIDER: String,
        @Query("STRAUTHKEY") STRAUTHKEY: String,
        @Query("parameter") parameter: String
    ): ResponseLoginSaas

    @POST("/api/sunfishes/checkLDAP")
    suspend fun ldapLogin(
        @Body ist: RequestLoginLdap
    ): ResponseLoginLdap

    @POST("/api/sunfishes/login")
    suspend fun login(
        @Body data: RequestLogin
    ): ResponseLogin

    @GET("auth/checkLDAP")
    suspend fun ldapLoginV2(
        @Query("ist") ist: String
    ): BaseResponseV2<Boolean>

    @POST("auth/login")
    suspend fun loginV2(
        @Body data: RequestLogin
    ): ResponseLogin

    /**
     * Logout
     */
    @POST("/api/sunfishes/logout")
    suspend fun logout(): Logout

    @POST("auth/logout")
    suspend fun logoutV2(): BaseResponseV2<Any>

    /**
     * Forgot password
     */
    @POST("/api/accessmanagements/newforgotPassword")
    suspend fun forgotPassword(
        @Query("company_code") companyCode: String,
        @Query("email_usr") emailUser: String
    ): ResponseForgotPassword

    @POST("accessmanagements/newforgotPassword")
    suspend fun forgotPasswordV2(
        @Query("companyCode") companyCode: String,
        @Query("emailUser") emailUser: String
    ): BaseResponseV2<Any>
}