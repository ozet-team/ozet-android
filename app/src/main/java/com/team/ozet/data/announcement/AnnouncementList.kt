package com.team.ozet.data.announcement

data class AnnouncementList(
    var basicList: List<AnnouncementModel>? = null,
    var bookMarkerList: List<AnnouncementModel>? = null,
    var recommendList: List<AnnouncementModel>? = null
)
