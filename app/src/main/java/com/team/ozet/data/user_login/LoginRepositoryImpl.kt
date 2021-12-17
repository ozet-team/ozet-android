package com.ljjy.projecta.data.login.source


import com.team.ozet.api.UserLogin
import com.team.ozet.data.user_login.Test
import com.team.ozet.data.user_login.UserEx
import io.reactivex.Single

class LoginRepositoryImpl(
    private val userLogin: UserLogin
) : LoginRepository {
    override fun postTest(test: Test): Single<Test> {
        return userLogin.postPasscodePass(test)
    }


//    override fun getUserInfo(loginId: String) : Single<SignUpInfo> {
//        return userLogin.getUserInfo(loginId)
//    }
//    override fun postLogin(loginRequest: LoginRequest) : Single<SignUpInfo> {
//        return userLogin.postLogin(loginRequest)
//    }

}