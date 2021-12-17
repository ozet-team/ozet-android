package com.team.ozet.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLDecoder

object ApiClient {
    private var instance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()
    // 서버 주소

     var str :String = URLDecoder.decode( "" , "EUC-KR" );

    const val URL = "https://api-staging.ozet.app/"

    // SingleTon 싱글톤 패턴 사용, 인스턴스 재생성 방지
    fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        return instance!!
    }
}