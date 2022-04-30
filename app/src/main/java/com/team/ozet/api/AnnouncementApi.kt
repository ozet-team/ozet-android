package com.team.ozet.api

import com.team.ozet.data.announcement.AnnouncementResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AnnouncementApi {

    @GET("api/v1/announcement/bookmarks/")
    fun getBookmarks(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int,
        @Query("user_id") userId:Int
    ):Single<AnnouncementResponse>

    //ordering "" 공백은 모든 공고
    @GET("api/v1/announcement/announcements/")
    fun getAnnouncement(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int,
        @Query("ordering") ordering:String
    ):Single<AnnouncementResponse>


}