package com.greatdayhr.support.feature.auth.data.model

import com.google.gson.annotations.SerializedName

data class RequestLogin(

    @SerializedName("deviceInfo")
    val deviceInfo: DeviceInfo,
    @SerializedName("ist")
    val ist: String,
    @SerializedName("keep")
    val keep: Boolean,
    @SerializedName("npwd")
    val npwd: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("preLoginData")
    val preLoginData: PreLoginData,
    @SerializedName("username")
    val username: String,
    @SerializedName("isKiosk")
    val iskiosk: Boolean

)

data class DeviceInfo(
    @SerializedName("DeviceID")
    val deviceID: String,
    @SerializedName("Model")
    val model: String,
    @SerializedName("Platform")
    val platform: String,
    @SerializedName("Ready")
    val ready: Boolean,
    @SerializedName("SFGOVersionCode")
    val sFGOVersionCode: String,
    @SerializedName("SFGOVersionNumber")
    val sFGOVersionNumber: String,
    @SerializedName("Version")
    val version: String
)

data class PreLoginData(
    @SerializedName("ACCOUNT")
    val aCCOUNT: String,
    @SerializedName("ACCOUNTNAME")
    val aCCOUNTNAME: String,
    @SerializedName("CUSTOM")
    val cUSTOM: List<Any>,
    @SerializedName("GOPATH")
    val gOPATH: String,
    @SerializedName("IST")
    val iST: String,
    @SerializedName("MODE")
    val mODE: List<Any>,
    @SerializedName("SFPATH")
    val sFPATH: String
)

data class ResponseLogin(
    @SerializedName("accId")
    val accId: Int,
    @SerializedName("attWifiCheck")
    val attWifiCheck: Boolean,
    @SerializedName("changePass")
    val changePass: Boolean,
    @SerializedName("companyCode")
    val companyCode: String,
    @SerializedName("companyId")
    val companyId: Int,
    @SerializedName("created")
    val created: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("emailVerified")
    val emailVerified: Any,
    @SerializedName("empId")
    val empId: String,
    @SerializedName("empNo")
    val empNo: String,
    @SerializedName("fullName")
    val fullName: String,
//    @SerializedName("functionAuth")
//    val functionAuth: FunctionAuth,
    @SerializedName("id")
    val id: String,
    @SerializedName("isSF6")
    val isSF6: Int,
    @SerializedName("isdefault")
    val isdefault: Boolean,
    @SerializedName("ist")
    val ist: Ist,
    @SerializedName("loginid")
    val loginid: String,
    @SerializedName("menu")
    val menu: Menu,
    @SerializedName("multiCompany")
    val multiCompany: MultiCompany,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("resetPassword")
    val resetPassword: Boolean,
    @SerializedName("ttl")
    val ttl: Int,
    @SerializedName("updateStorage")
    val updateStorage: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("userLdap")
    val userLdap: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("error")
    val error: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("empphotopath")
    val empphotopath: String
) {
    fun getCompanyName(): String {
        return if (!multiCompany.companyList.isNullOrEmpty()) {
            multiCompany.companyList[0].companyName
        } else {
            multiCompany.companyListV2[0].companyNameV2
        }
    }
}

data class FunctionAuth(
    @SerializedName("hrm.attendance")
    val hrmattendance: String
)

data class MultiCompany(
    @SerializedName("company_list")
    val companyList: List<Company>,
    @SerializedName("main_company")
    val mainCompany: Int,
    @SerializedName("main_company_code")
    val mainCompanyCode: String,
    @SerializedName("companyList")
    val companyListV2: List<Company>
)

data class Company(
    @SerializedName("company_code")
    val companyCode: String,
    @SerializedName("company_id")
    val companyId: Int,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("companyName")
    val companyNameV2: String
)

data class Menu(
    @SerializedName("payslip-printer")
    val payslip_printer: Boolean,
    @SerializedName("att-barcode")
    val att_barcode: Boolean
)

data class Ist(
    @SerializedName("GOPATH")
    val gOPATH: String,
    @SerializedName("LNUMBER")
    val lNUMBER: String,
    @SerializedName("PNUMBER")
    val pNUMBER: String,
    @SerializedName("SFPATH")
    val sFPATH: String,
    @SerializedName("accid")
    val accid: Int,
    @SerializedName("cocode")
    val cocode: String,
    @SerializedName("coid")
    val coid: Int,
    @SerializedName("coname")
    val coname: String,
    @SerializedName("isSF6")
    val isSF6: Int
)