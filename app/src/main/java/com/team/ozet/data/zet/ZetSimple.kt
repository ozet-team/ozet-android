package com.team.ozet.data.zet

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class ZetSimple(
    var content:String = "",
    var sub:String = ""
):Serializable
