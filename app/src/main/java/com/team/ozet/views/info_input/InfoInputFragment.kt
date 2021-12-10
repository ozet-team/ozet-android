package com.team.ozet.views.info_input

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentInfoInputBinding
import com.team.ozet.views.join.JoinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoInputFragment : BaseFragment<FragmentInfoInputBinding>(R.layout.fragment_info_input) {
    private val viewModel: InfoInputViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
        callback()
        aa()
    }

    private fun callback() {
        with(viewModel) {
            clickEvent.observe(this@InfoInputFragment, Observer {
                findNavController().navigate(R.id.action_infoInputFragment_to_mainFragment)
            })
        }
    }
    fun aa(){
        val arg = requireArguments()
        val phonNumber = arg.getString("userPhonNumber")
//        binding.incluePhone.etBase.text = phonNumber
    }
}