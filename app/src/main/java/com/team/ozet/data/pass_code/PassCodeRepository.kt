package com.team.ozet.data.pass_code

import io.reactivex.Single

interface PassCodeRepository {
    fun postPassCode(passCode: PassCode) : Single<RequestedVerify>
    fun postPassCodeRequest(passCode: PassCode) : Single<RequestedVerify>
}