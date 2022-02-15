package com.team.ozet.views.onbording

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentJoinBinding
import com.team.ozet.databinding.FragmentOnbordingBinding
import com.team.ozet.views.info_input.InfoInputViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnbordingFragment : BaseFragment<FragmentOnbordingBinding>(R.layout.fragment_onbording) {

    private val viewModel: OnbordingViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
        callback()
        aa()
    }

    private fun callback() {
        with(viewModel) {

        }
    }
    fun aa(){
        val arg = requireArguments()
        val phonNumber = arg.getString("userPhonNumber")
//        binding.incluePhone.etBase.text = phonNumber
    }

}