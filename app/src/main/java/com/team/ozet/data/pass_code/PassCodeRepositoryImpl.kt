package com.ljjy.projecta.data.login.source


import com.team.ozet.api.AuthPassCode
import com.team.ozet.data.pass_code.PassCode
import com.team.ozet.data.pass_code.PassCodeRepository
import com.team.ozet.data.pass_code.RequestedVerify
import io.reactivex.Single

class PassCodeRepositoryImpl(
    private val authPassCode: AuthPassCode
) : PassCodeRepository {
    override fun postPassCodeRequest(passCode: PassCode): Single<RequestedVerify> {
        return authPassCode.postPassCodeRequest(passCode)
    }
}