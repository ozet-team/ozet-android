package com.team.ozet.api


import io.reactivex.Single
import retrofit2.http.*

interface UserLogin {

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
}