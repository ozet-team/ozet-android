package com.team.ozet.module

import com.ljjy.projecta.data.login.source.LoginRepository
import com.ljjy.projecta.data.login.source.LoginRepositoryImpl
import com.ljjy.projecta.data.login.source.PassCodeRepositoryImpl
import com.team.ozet.data.pass_code.PassCodeRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
//    single<HomeRepository> { HomeRepositoryImpl() }
    single<LoginRepository> {LoginRepositoryImpl(get())}
    single<PassCodeRepository> {PassCodeRepositoryImpl(get())}

}