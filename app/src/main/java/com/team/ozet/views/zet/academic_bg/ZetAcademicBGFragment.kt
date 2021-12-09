package com.team.ozet.views.zet.academic_bg

import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetAcademicBgBinding

class ZetAcademicBGFragment : BaseFragment<FragmentZetAcademicBgBinding>(R.layout.fragment_zet_academic_bg) {
    override fun init() {
        binding.includeBtn.button.text = "완료"
    }

}