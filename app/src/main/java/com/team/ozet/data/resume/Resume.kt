package com.team.ozet.data.resume

import androidx.annotation.Keep

@Keep data class Resume(
    var academic: List<Academic>,
    var career: List<Career>,
    var certificate: List<Certificate>,
    var military: Military
)