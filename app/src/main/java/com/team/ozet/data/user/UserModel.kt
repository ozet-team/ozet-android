package com.team.ozet.data.user

data class UserModel(
    val address: String = "",
    val birthday: String = "",
    val email: String = "",
    val gender: String = "",
    val introduce: String = "",
    val name: String = "",
    val phoneNumber: String = "",
    val policyForPrivacyAgreed: String = "",
    val policyForTermsAgreed: String = "",
    val profileImage: String = "",
    val snsList: List<SnsModel>,
    val username: String = ""
)