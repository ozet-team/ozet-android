package com.team.ozet.data.user

import java.io.Serializable

data class UserModel(
    var address: String = "",
    var birthday: String = "",
    var email: String = "",
    var gender: String = "",
    var introduce: String = "",
    var name: String = "",
    var phoneNumber: String = "",
    var policyForPrivacyAgreed: String = "",
    var policyForTermsAgreed: String = "",
    var profileImage: String = "",
    var snsList: List<SnsModel>,
    var username: String = ""
) : Serializable {
    constructor():this("","","","","","","","","","", arrayListOf<SnsModel>(SnsModel()),"")
}