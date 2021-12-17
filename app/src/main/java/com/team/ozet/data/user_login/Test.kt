package com.team.ozet.data.user_login

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Test(

    var user_id:String = "",
    var token : String = "",
    var phoneNumber: String = "",
    @SerializedName("requestedVerify")
    var requestedVerify:List<RequestedVerify?>? =null,

    @SerializedName("user")
    @Expose
    var user:User? =null
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
