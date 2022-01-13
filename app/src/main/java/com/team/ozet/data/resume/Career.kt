package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable
@Keep data class Career(
    val company: String,
    val joinAt: String,
    val position: String,
    val quitAt: String,
    val workedOn: String
):Serializable{
    constructor():this("","","","","",)
}