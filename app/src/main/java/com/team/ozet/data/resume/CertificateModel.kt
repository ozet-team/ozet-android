package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class CertificateModel(
    val id: Int,
    var certificateAt: String,
    var name: String,
    var vendor: String
):Serializable{
    constructor(id:Int):this(id,"","","")
    constructor():this(0,"","","")
}
