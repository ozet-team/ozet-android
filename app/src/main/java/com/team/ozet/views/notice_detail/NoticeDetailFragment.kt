package com.team.ozet.views.notice_detail

import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentNoticeDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoticeDetailFragment : BaseFragment<FragmentNoticeDetailBinding>(R.layout.fragment_notice_detail) {
    private val viewModel:NoticeDetailViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
    }

}