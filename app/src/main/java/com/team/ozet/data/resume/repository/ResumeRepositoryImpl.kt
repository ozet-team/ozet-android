package com.team.ozet.data.resume.repository

import com.team.ozet.api.ResumeApi
import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single

class ResumeRepositoryImpl (private val resumeApi: ResumeApi) : ResumeRepository{

    override fun getResume(userId: String): Single<ResumeModel> =
        resumeApi.getResume(userId)

    override fun postAcademicAdd(token: String, body: AcademicModel): Single<AcademicModel> =resumeApi.postAcademicAdd(token,body)
    override fun patchAcademicUpdate(token: String, id: Int, body: AcademicModel): Single<AcademicModel> =resumeApi.patchAcademicUpdate(token, id, body)
    override fun deleteAcademic(token: String, id: Int): Completable = resumeApi.deleteAcademicDelete(token, id)

    override fun postCareerAdd(token: String, body: CareerModel): Single<CareerModel> =resumeApi.postCareerAdd(token,body)
    override fun patchCareerUpdate(token: String, id: Int, body: CareerModel): Single<CareerModel> =resumeApi.patchCareerUpdate(token, id, body)
    override fun deleteCareer(token: String, id: Int): Completable = resumeApi.deleteCareerDelete(token, id)

    override fun postCertificateAdd(token: String, body: CertificateModel): Single<CertificateModel> =resumeApi.postCertificateAdd(token,body)
    override fun patchCertificateUpdate(token: String, id: Int, body: CertificateModel): Single<CertificateModel> =resumeApi.patchCertificateUpdate(token, id, body)
    override fun deleteCertificate(token: String, id: Int): Completable = resumeApi.deleteCertificateDelete(token, id)

    override fun postMilitaryAdd(token: String, body: MilitaryModel): Single<MilitaryModel> =resumeApi.postMilitaryAdd(token,body)
    override fun patchMilitaryUpdate(token: String, id: Int, body: MilitaryModel): Single<MilitaryModel> =resumeApi.patchMilitaryUpdate(token, id, body)
    override fun deleteMilitary(token: String, id: Int): Completable = resumeApi.deleteMilitaryDelete(token, id)


}