package com.team.ozet.data.pass_code

import io.reactivex.Single

interface PassCodeRepository {
    fun postPassCode(passCode: PassCode) : Single<PassCode>
    fun postPassCodeRequest(passCode: PassCode) : Single<PassCode>
}