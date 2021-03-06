package com.team.ozet.data.resume.remote

import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single

interface ResumeRepository {
    fun getResume(userId: String): Single<ResumeModel>
    fun postAcademicAdd(token: String,body:AcademicModel): Single<AcademicModel>
    fun patchAcademicUpdate(token: String,id:Int,body:AcademicModel): Single<AcademicModel>
    fun deleteAcademic(token: String,id:Int): Completable

    fun postCareerAdd(token: String,body: CareerModel): Single<CareerModel>
    fun patchCareerUpdate(token: String,id:Int,body:CareerModel): Single<CareerModel>
    fun deleteCareer(token: String,id:Int): Completable

    fun postCertificateAdd(token: String,body: CertificateModel): Single<CertificateModel>
    fun patchCertificateUpdate(token: String,id:Int,body:CertificateModel): Single<CertificateModel>
    fun deleteCertificate(token: String,id:Int): Completable

    fun patchMilitaryUpdate(token: String,body:MilitaryModel): Single<MilitaryModel>

}