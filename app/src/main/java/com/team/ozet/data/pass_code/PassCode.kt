package com.team.ozet.data.pass_code

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.team.ozet.data.user_login.User
import kotlinx.parcelize.Parcelize


data class PassCode(
    var phoneNumber: String,
    var passCode: String ="",
    @SerializedName("requestedVerify")
    var requestedVerify:List<RequestedVerify?>? =null,

    @SerializedName("user")
    @Expose
    var user: User? =null
)

@Entity(tableName = "requestedVerify")
data class RequestedVerify(
    var requesterPhoneNumber: String = "",
    var requesterDeviceUuid: String = "",
    var status: String = "",
    var expireAt: String = "",
)
@Entity(tableName = "user")
data class User(
    @SerializedName("username")
    @Expose
    var username: String = "",
    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("email")
    @Expose
    var email: String = "",
    @SerializedName("phoneNumber")
    @Expose
    var phoneNumber: String = "",
)
// requestedVerify를 USER ㅊㅓ럼 작업 하기