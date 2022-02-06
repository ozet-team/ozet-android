package com.team.ozet.api

import com.team.ozet.data.resume.AcademicModel
import com.team.ozet.data.resume.ResumeModel
import com.team.ozet.data.user.UserModel
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface UserApi {

    @GET("api/v1/member/user/me/")
    fun getUser(@Header("authorization") token: String): Single<UserModel>

    @PATCH("api/v1/member/user/me/")
    fun patchUserUpdate(
        @Header("authorization") token: String,
        @Body body: UserModel
    ): Completable
}