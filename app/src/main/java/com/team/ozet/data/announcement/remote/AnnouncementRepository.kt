package com.team.ozet.data.announcement.remote

import com.team.ozet.data.announcement.AnnouncementResponse
import io.reactivex.Single
import okhttp3.ResponseBody

interface AnnouncementRepository {
    fun getBookmarks(offset: Int, limit: Int): Single<AnnouncementResponse>
    fun getAnnouncement(offset: Int,limit: Int):Single<AnnouncementResponse>
}