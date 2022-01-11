package com.team.ozet.views.zet.academic_bg

import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetAcademicBgBinding

class ZetAcademicBGFragment : BaseFragment<FragmentZetAcademicBgBinding>(R.layout.fragment_zet_academic_bg) {

    override fun init() {
        appbar()
    }

    private fun appbar(){
        binding.appbar.tvSubTitle().setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun checkWorking(){
        binding.scCheckAttending.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cmAcademicDayEnd.checkWorking(isChecked,binding.scCheckAttending.text.toString())
        }
    }
}