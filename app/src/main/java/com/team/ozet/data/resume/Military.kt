package com.team.ozet.data.resume

import androidx.annotation.Keep

@Keep
data class Military(
    val exemptionReason: String,
    val joinAt: String,
    val quitAt: String,
    val service: String
)