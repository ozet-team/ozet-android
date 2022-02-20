package com.team.ozet.module

import com.ljjy.projecta.data.login.source.LoginRepository
import com.ljjy.projecta.data.login.source.LoginRepositoryImpl
import com.ljjy.projecta.data.login.source.PassCodeRepositoryImpl
import com.team.ozet.data.announcement.remote.AnnouncementRepository
import com.team.ozet.data.announcement.remote.AnnouncementRepositoryImpl
import com.team.ozet.data.pass_code.PassCodeRepository
import com.team.ozet.data.resume.remote.ResumeRepository
import com.team.ozet.data.resume.remote.ResumeRepositoryImpl
import com.team.ozet.data.user.repository.UserRepository
import com.team.ozet.data.user.repository.UserRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
//    single<HomeRepository> { HomeRepositoryImpl() }
    single<LoginRepository> {LoginRepositoryImpl(get())}
    single<PassCodeRepository> {PassCodeRepositoryImpl(get())}
    single<ResumeRepository> {ResumeRepositoryImpl(get())}
    single<UserRepository>{UserRepositoryImpl(get())}
    single<AnnouncementRepository>{AnnouncementRepositoryImpl(get())}
}