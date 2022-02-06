package com.team.ozet.data.user

import java.io.Serializable

data class SnsModel(
    val url: String,
    val username: String
):Serializable{
    constructor():this("","")
}