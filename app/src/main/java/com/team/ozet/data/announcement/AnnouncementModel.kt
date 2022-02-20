package com.team.ozet.data.announcement

data class AnnouncementModel(
    var description: String,
    var employeeTypes: List<Any>,
    var expireType: String,
    var expiredDatetime: String,
    var id: Int,
    var managerName: String,
    var managerPhoneNumber: String,
    var payAmount: Long,
    var payType: String,
    var shopLocation: String,
    var shopName: String,
    var title: String,
    var workingHour: String
)