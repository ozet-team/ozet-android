package com.team.ozet.views.zet.career

import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCareerBinding

class ZetCareerFragment : BaseFragment<FragmentZetCareerBinding>(R.layout.fragment_zet_career) {



    override fun init() {
        binding.includeBtn.button.text = "완료"

    }


}