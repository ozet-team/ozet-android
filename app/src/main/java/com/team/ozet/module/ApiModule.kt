package com.team.ozet.module

import com.google.gson.GsonBuilder
import com.team.ozet.api.ApiClient
import com.team.ozet.api.AuthPassCode
import com.team.ozet.api.ResumeApi
import com.team.ozet.api.UserLogin
import com.team.ozet.data.pass_code.PassCode
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val apiModule:Module = module {
    val gson = GsonBuilder().setLenient().create()
    single {
        Retrofit.Builder()
            .baseUrl(ApiClient.URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(AuthPassCode::class.java)
    }
    single {
        Retrofit.Builder()
            .baseUrl(ApiClient.URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ResumeApi::class.java)

    }

}