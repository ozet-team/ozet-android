package com.team.ozet.data.announcement.remote

import com.team.ozet.data.announcement.BookMarksModel
import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single

interface AnnouncementRepository {
    fun getBookmarks(offset: Int, limit: Int,token: String): Single<BookMarksModel>
}