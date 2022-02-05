package com.team.ozet.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date

class Date {
    fun sdfUTC():SimpleDateFormat{
        var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return sdf
    }

    fun sdfDiffDay():SimpleDateFormat{
        var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return sdf
    }
    fun utcToAsia(conversionTime:String): String {
        try {
            val date: Date = sdfUTC().parse(conversionTime)
            var conversionTime = sdfDiffDay().format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return conversionTime
    }
}