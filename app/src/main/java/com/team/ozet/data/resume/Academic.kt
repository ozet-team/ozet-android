package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable
import java.lang.reflect.Constructor

@Keep data class Academic(
    var joinAt: String,
    var location: String,
    var major: String,
    var quitAt: String,

):Serializable{
    constructor():this("","","","")
}