package com.team.ozet.data.announcement.remote

import com.team.ozet.api.AnnouncementApi
import com.team.ozet.api.ResumeApi
import com.team.ozet.data.announcement.BookMarksModel
import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single

class AnnouncementRepositoryImpl (private val announcementApi: AnnouncementApi) : AnnouncementRepository{
    override fun getBookmarks(offset: Int, limit: Int, token: String): Single<BookMarksModel>
    = announcementApi.getBookmarks(token, offset, limit)
}