package com.team.ozet.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(OZET_APP, Context.MODE_PRIVATE)

    companion object {
        private const val OZET_APP = "OZET_APP"
        private const val APP_INTRO = "APP_INTRO"
        private const val OZET_TOKEN = "TOKEN"
    }

    var ozetToken: String
    get() = sharedPref.getString(OZET_TOKEN,"").toString()
    set(value) {
        val editor = sharedPref.edit()
        editor.putString(OZET_TOKEN,value)
        editor.apply()
    }
}