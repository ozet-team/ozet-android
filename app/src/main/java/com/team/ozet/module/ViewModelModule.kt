package com.team.ozet.module

import com.team.ozet.views.main.MainViewModel
import com.team.ozet.views.main_fragment.MainFragmentViewModel
import com.team.ozet.views.notice_detail.NoticeDetailViewModel
import com.team.ozet.views.notice_list.NoticeListViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule: Module = module {
    viewModel { MainViewModel() }
    viewModel { NoticeDetailViewModel() }
    viewModel { MainFragmentViewModel() }
    viewModel { NoticeListViewModel() }

//    viewModel {  }
}