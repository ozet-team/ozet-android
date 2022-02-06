package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class AcademicModel(
    val id: Int,
    var name: String?,
    var joinAt: String?,
    var location: String,
    var major: String,
    var quitAt: String?,

):Serializable{
    constructor(id: Int):this(id,"","","","","")
    constructor():this(0,"","","","","")
}