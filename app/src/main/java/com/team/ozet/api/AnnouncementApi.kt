package com.team.ozet.api

import com.team.ozet.data.announcement.AnnouncementResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AnnouncementApi {

    @GET("api/v1/announcement/announcements/")
    fun getBookmarks(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int
    ):Single<AnnouncementResponse>

    @GET("api/v1/announcement/announcements/")
    fun getAnnouncement(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int
    ):Single<AnnouncementResponse>
}