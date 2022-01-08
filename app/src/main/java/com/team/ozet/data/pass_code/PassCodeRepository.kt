package com.team.ozet.data.pass_code

import io.reactivex.Single

interface PassCodeRepository {
    fun postPassCodeRequest(passCode: PassCode) : Single<PassCode>
}