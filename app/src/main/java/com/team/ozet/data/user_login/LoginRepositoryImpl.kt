package com.ljjy.projecta.data.login.source


import com.team.ozet.api.UserLogin
import io.reactivex.Single

class LoginRepositoryImpl(
    private val userLogin: UserLogin
) : LoginRepository {

//    override fun getUserInfo(loginId: String) : Single<SignUpInfo> {
//        return userLogin.getUserInfo(loginId)
//    }
//    override fun postLogin(loginRequest: LoginRequest) : Single<SignUpInfo> {
//        return userLogin.postLogin(loginRequest)
//    }
}