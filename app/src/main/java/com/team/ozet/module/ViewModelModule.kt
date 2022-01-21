package com.team.ozet.module

import com.team.ozet.base.BaseViewModel
import com.team.ozet.views.info_input.InfoInputViewModel
import com.team.ozet.views.join.JoinViewModel
import com.team.ozet.views.main.MainViewModel
import com.team.ozet.views.main_fragment.MainFragmentViewModel
import com.team.ozet.views.my_page.MypageViewModel
import com.team.ozet.views.notice_detail.NoticeDetailViewModel
import com.team.ozet.views.notice_list.NoticeListViewModel
import com.team.ozet.views.zet.academic_bg.ZetAcademicBGViewModel
import com.team.ozet.views.zet.career.ZetCareerViewModel
import com.team.ozet.views.zet.certificate.ZetCertificateViewModel
import com.team.ozet.views.zet.main.ZetMainViewModel
import com.team.ozet.views.zet.military_service.ZetMilitaryServiceViewModel
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
    viewModel { MypageViewModel() }
    viewModel { ZetCareerViewModel() }
    viewModel { ZetMainViewModel(get()) }
    viewModel { ZetAcademicBGViewModel() }
    viewModel { ZetCertificateViewModel() }
    viewModel { ZetMilitaryServiceViewModel() }
//    viewModel {  }
}