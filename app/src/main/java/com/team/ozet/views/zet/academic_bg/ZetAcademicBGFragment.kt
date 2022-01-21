package com.team.ozet.views.zet.academic_bg

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetAcademicBgBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetAcademicBGFragment : BaseFragment<FragmentZetAcademicBgBinding>(R.layout.fragment_zet_academic_bg) {
    private val viewModel:ZetAcademicBGViewModel by viewModel()
    private val args:ZetAcademicBGFragmentArgs by navArgs()
    


    override fun init() {
        binding.vm = viewModel
        appbar()
        viewModel.setAcademicData(args.academic)
    }

    private fun appbar(){
        binding.appbar.tvSubFirst().setOnClickListener {
            findNavController().popBackStack()
        }
    }



    private fun checkWorking(){
        binding.scCheckAttending.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cmAcademicDayEnd.checkWorking(isChecked,binding.scCheckAttending.text.toString())
        }
    }
}