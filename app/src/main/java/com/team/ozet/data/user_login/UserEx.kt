package com.team.ozet.data.user_login

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class UserEx(
        @PrimaryKey var id: String = "",
        var name: String = "",
        var fcm: String = "",
        var email: String = "",
        var pw: String = "",
        var image: String = "",
        var tel: String = ""
) : Parcelable