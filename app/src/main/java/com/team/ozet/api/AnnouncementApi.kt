package com.team.ozet.api

import com.team.ozet.data.announcement.BookMarksModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AnnouncementApi {

    @GET("api/v1/announcement/bookmarks/")
    fun getBookmarks(
        @Header("authorization") token: String,
        @Query("offset") offset:Int,
        @Query("limit") limit:Int
    ):Single<BookMarksModel>
}