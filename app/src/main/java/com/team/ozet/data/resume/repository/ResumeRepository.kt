package com.team.ozet.data.resume.repository

import com.team.ozet.data.resume.Resume
import io.reactivex.Single

interface ResumeRepository {
    fun getResume2(token:String,id:String) : Single<Resume>
    fun getResume(token:String) : Single<Resume>
}