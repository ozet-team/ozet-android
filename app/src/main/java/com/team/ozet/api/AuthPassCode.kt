package com.team.ozet.api

import com.team.ozet.data.pass_code.PassCode
import com.team.ozet.data.user_login.Test
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthPassCode {
    //패스코드 인증 API
    @POST("api/v1/member/auth/passcode") //?loginId=cloud0
    fun postPassCode(@Query("phoneNumber",) loginId: String): Single<PassCode>

    //패스코드 강제 성공 API @DEBUG
    @POST("api/v1/member/auth/passcode/pass") //?loginId=cloud0
    fun postDebugPass(@Query("user_id") loginId: String): Single<PassCode>

    //패스코드 인증 요청 API
    @POST("api/v1/member/auth/passcode/request") //?loginId=cloud0
    fun postPassCodeRequest(@Body body: PassCode): Single<PassCode>
}