package com.team.ozet.data.announcement

data class BookMarksModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<AnnouncementResultModel>
)