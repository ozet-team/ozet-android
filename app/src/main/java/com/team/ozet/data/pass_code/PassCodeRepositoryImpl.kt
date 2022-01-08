package com.ljjy.projecta.data.login.source


import com.team.ozet.api.AuthPassCode
import com.team.ozet.data.pass_code.PassCode
import com.team.ozet.data.pass_code.PassCodeRepository
import io.reactivex.Single

class PassCodeRepositoryImpl(
    private val authPassCode: AuthPassCode
) : PassCodeRepository {
    override fun postPassCodeRequest(passCode: PassCode): Single<PassCode> {
        return authPassCode.postPassCodeRequest(passCode)
    }
}