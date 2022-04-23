package com.team.ozet.data.announcement

import androidx.annotation.Keep
import java.io.Serializable

@Keep data class AnnouncementModel(
    var description: String,
    var employeeTypes: List<EmployeeTypesModel>,
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
    var workingHour: String,
    var bookmarkCount: String,
    var imageUrl: String,
):Serializable