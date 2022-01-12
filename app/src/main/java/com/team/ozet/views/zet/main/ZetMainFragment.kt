package com.team.ozet.views.zet.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetMainFragment : BaseFragment<FragmentZetMainBinding>(R.layout.fragment_zet_main) {
    private val viewModel:ZetMainViewModel by viewModel()
    override fun init() {
        binding.vm = viewModel

        viewModelCallBack()
        addRvCallback()
        viewModel.setSimpleList()
        viewModel.getResume()

    }

    private fun viewModelCallBack(){
        with(viewModel){
            zetSimpleList.observe(this@ZetMainFragment, Observer {
                binding.arAcademicBg.addItems(it)
            })
        }
    }

    private fun addRvCallback(){
        binding.arAcademicBg.btnAdd().setOnClickListener{
            findNavController().navigate(R.id.action_zetMainFragment_to_zetAcademicBGFragment)
        }
        binding.arAcademicBg.tvSub().setOnClickListener {
            findNavController().navigate(R.id.action_zetMainFragment_to_zetAcademicBGFragment)
        }


    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(thisContext, "resume", Toast.LENGTH_SHORT).show()
    }
}