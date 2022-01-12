package com.team.ozet.data.resume.repository

import com.team.ozet.api.ResumeApi
import com.team.ozet.data.resume.Resume
import io.reactivex.Single

class ResumeRepositoryImpl (private val resumeApi: ResumeApi) : ResumeRepository{



    override fun getResume2(token: String, id: String): Single<Resume> =
        resumeApi.getResume2(token,id)

    override fun getResume(token: String): Single<Resume> =
        resumeApi.getResume(token)
}