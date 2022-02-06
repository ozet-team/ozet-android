package com.team.ozet.api

import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface ResumeApi {

    @GET("api/v1/member/user/{user_id}/resume/")
    fun getResume(@Path("user_id") userId: String): Single<ResumeModel>

    @GET("api/v1/member/user/me/resume/academics/")
    fun getAcademic(@Header("authorization") token: String): Single<AcademicModel>

    @POST("api/v1/member/user/me/resume/academics/")
    fun postAcademicAdd(
        @Header("authorization") token: String,
        @Body body: AcademicModel
    ): Single<AcademicModel>

    @PATCH("api/v1/member/user/me/resume/academics/{id}/")
    fun patchAcademicUpdate(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
        @Body body: AcademicModel
    ): Single<AcademicModel>

    @DELETE("api/v1/member/user/me/resume/academics/{id}/")
    fun deleteAcademicDelete(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
    ) : Completable

    @POST("api/v1/member/user/me/resume/careers/")
    fun postCareerAdd(
        @Header("authorization") token: String,
        @Body body: CareerModel
    ): Single<CareerModel>

    @PATCH("api/v1/member/user/me/resume/careers/{id}/")
    fun patchCareerUpdate(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
        @Body body: CareerModel
    ): Single<CareerModel>

    @DELETE("api/v1/member/user/me/resume/careers/{id}/")
    fun deleteCareerDelete(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
    ) : Completable

    @POST("api/v1/member/user/me/resume/certificate/")
    fun postCertificateAdd(
        @Header("authorization") token: String,
        @Body body: CertificateModel
    ): Single<CertificateModel>

    @PATCH("api/v1/member/user/me/resume/certificates/{id}/")
    fun patchCertificateUpdate(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
        @Body body: CertificateModel
    ): Single<CertificateModel>

    @DELETE("api/v1/member/user/me/resume/certificates/{id}/")
    fun deleteCertificateDelete(
        @Header("authorization") token: String,
        @Path ("id") id: Int,
    ) : Completable


    @PATCH("api/v1/member/user/me/resume/military/")
    fun patchMilitaryUpdate(
        @Header("authorization") token: String,
        @Body body: MilitaryModel
    ): Single<MilitaryModel>


}