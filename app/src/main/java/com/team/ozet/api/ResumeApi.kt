package com.team.ozet.api

import com.team.ozet.data.resume.Resume
import com.team.ozet.data.user_login.Test
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ResumeApi {

    @GET("api/v1/member/user/me/resume")
    fun getResume2(@Header("Authorization") Token : String ,@Query("id") id:String): Single<Resume>
    @GET("api/v1/member/user/me/resume")
    fun getResume(@Header("authorization") Token : String ): Single<Resume>
}