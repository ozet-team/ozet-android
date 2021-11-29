package com.team.ozet.module

import com.team.ozet.utils.PreferenceManager
import org.koin.core.module.Module
import org.koin.dsl.module

val localDataModule: Module = module {
    // Shared
    single<PreferenceManager> { PreferenceManager(get()) }

}