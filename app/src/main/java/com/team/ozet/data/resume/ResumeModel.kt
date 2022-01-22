package com.team.ozet.data.resume

import androidx.annotation.Keep

@Keep data class ResumeModel(
    var academic: List<AcademicModel>,
    var career: List<CareerModel>,
    var certificate: List<CertificateModel>,
    var military: MilitaryModel
)