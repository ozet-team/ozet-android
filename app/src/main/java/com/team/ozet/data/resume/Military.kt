package com.team.ozet.data.resume

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Military(
    var exemptionReason: String,
    var joinAt: String,
    var quitAt: String,
    var service: String
): Serializable {
    constructor():this("","","","",)
}