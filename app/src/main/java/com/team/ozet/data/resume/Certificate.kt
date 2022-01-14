package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class Certificate(
    var certificateAt: String,
    var name: String,
    var vendor: String
):Serializable{
    constructor():this("","","")
}