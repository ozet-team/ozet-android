package com.team.ozet.data.announcement

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep data class AnnouncementResponse(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("next")
    @Expose
    val next: String,
    @SerializedName("previous")
    @Expose
    val previous: String,
    @SerializedName("results")
    @Expose
    val results: List<AnnouncementModel>
)
