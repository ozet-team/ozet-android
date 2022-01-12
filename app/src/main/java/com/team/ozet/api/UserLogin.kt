package com.team.ozet.api


import com.team.ozet.data.user_login.Test
import com.team.ozet.data.user_login.UserEx
import io.reactivex.Single
import retrofit2.http.*

interface UserLogin {
//    //로그인 체크
//    @POST("api/v1/member/auth/passcode") //?loginId=cloud0
//    fun getUserInfo(@Query("loginId") loginId: String): Single<SignUpInfo>

//    //로그인 체크
//    @GET("api/v1/users/loginIdChk") //?loginId=cloud0
//    fun getUserInfo(@Query("loginId") loginId: String): Single<SignUpInfo>
//
//    //회원가입
//    @POST("api/v1/users/signUp")
//    fun postSignUp(@Body body: SignUpInfo): Single<SignUpInfo>
//
//    //로그인
//    @POST("api/v1/users/signIn")
//    fun postLogin(@Body body: LoginRequest): Single<SignUpInfo>
//
//    //로그아웃
//    @DELETE("api/v1/users/signOut")
//    fun delSignOut(@Header("Authorization") token: String): Single<SignUpInfo>

//    test
    @GET("api/v1/announcement/announcements")
    fun test():Single<Test>
    @GET("api/schema")
    fun test2():Single<Test>
        //passcode result
    @POST("api/v1/member/auth/passcode/request")
    fun postPasscodeResult(@Body body: Test): Single<Test>
    @POST("api/v1/member/auth/passcode/pass")
    fun postPasscodePass(
        @Body body: Test): Single<Test>
}