package com.team.ozet.data.announcement

data class AnnouncementList(
    var list: ArrayList<AnnouncementModel> = arrayListOf(),
    val name:String = ""
)
