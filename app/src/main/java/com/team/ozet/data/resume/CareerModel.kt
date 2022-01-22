package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable
@Keep data class CareerModel(
    val id: Int,
    var company: String,
    var joinAt: String,
    var position: String,
    var quitAt: String,
    var workedOn: String
):Serializable{
    constructor(id:Int):this(id,"","","","","",)
    constructor():this(0,"","","","","",)

}