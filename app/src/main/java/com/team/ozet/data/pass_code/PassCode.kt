package com.team.ozet.data.pass_code

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PassCode(
    var phoneNumber: String,
    var passCode: String ="",
    var userId: String="",
    @SerializedName("requestedVerify")
    @Expose
    var requestedVerify:RequestedVerify? =null,

    @SerializedName("user")
    @Expose
    var user: User? =null
)

@Entity(tableName = "requestedVerify")
data class RequestedVerify(
    @SerializedName("requesterPhoneNumber")
    @Expose
    var requesterPhoneNumber: String = "",
    @SerializedName("requesterDeviceUuid")
    @Expose
    var requesterDeviceUuid: String = "",
    @SerializedName("status")
    @Expose
    var status: String = "",
    @SerializedName("expireAt")
    @Expose
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

@Entity(tableName = "token")
data class Token(
    @SerializedName("token")
    @Expose
    var token: String = ""
)