package com.team.ozet.module

import com.team.ozet.base.BaseViewModel
import com.team.ozet.views.info_input.InfoInputViewModel
import com.team.ozet.views.join.JoinViewModel
import com.team.ozet.views.main.MainViewModel
import com.team.ozet.views.main_fragment.MainFragmentViewModel
import com.team.ozet.views.my_page.MypageViewModel
import com.team.ozet.views.notice_detail.NoticeDetailViewModel
import com.team.ozet.views.notice_list.NoticeListViewModel
import com.team.ozet.views.zet.career.ZetCareerViewModel
import com.team.ozet.views.zet.main.ZetMainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule: Module = module {
    viewModel { MainViewModel() }
    viewModel { NoticeDetailViewModel() }
    viewModel { MainFragmentViewModel() }
    viewModel { NoticeListViewModel() }
    viewModel { JoinViewModel(get()) }
    viewModel { InfoInputViewModel() }
    viewModel { ZetCareerViewModel() }
    viewModel { MypageViewModel() }
    viewModel { ZetMainViewModel(get()) }

//    viewModel {  }
}