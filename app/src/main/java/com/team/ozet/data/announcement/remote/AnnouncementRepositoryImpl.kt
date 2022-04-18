package com.team.ozet.data.announcement.remote

import android.util.Log
import com.team.ozet.api.AnnouncementApi
import com.team.ozet.api.ResumeApi
import com.team.ozet.data.announcement.AnnouncementResponse
import com.team.ozet.data.resume.*
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody

class AnnouncementRepositoryImpl (private val announcementApi: AnnouncementApi) : AnnouncementRepository{
    override fun getBookmarks(offset: Int, limit: Int): Single<AnnouncementResponse> {
       Log.i("AAA"," book -------------")
        return  announcementApi.getBookmarks(limit,offset)
    }


    override fun getAnnouncement(offset: Int, limit: Int): Single<AnnouncementResponse>
    = announcementApi.getAnnouncement(limit,offset)
}