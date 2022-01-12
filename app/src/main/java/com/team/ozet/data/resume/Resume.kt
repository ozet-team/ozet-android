package com.team.ozet.data.resume

data class Resume(
    val academic: List<Academic>,
    val career: List<Career>,
    val certificate: List<Certificate>,
    val military: Military
)