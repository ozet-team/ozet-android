package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class Certificate(
    val certificateAt: String,
    val name: String,
    val vendor: String
):Serializable{
    constructor():this("","","")
}