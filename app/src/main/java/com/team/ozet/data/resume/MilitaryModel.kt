package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class MilitaryModel(
    val id: Int,
    var exemptionReason: String = "",
    var joinAt: String = "",
    var quitAt: String = "",
    var service: String = ""
) : Serializable {
    constructor(id: Int) : this(id, "", "", "", "")
    constructor() : this(0, "", "", "", "")

}