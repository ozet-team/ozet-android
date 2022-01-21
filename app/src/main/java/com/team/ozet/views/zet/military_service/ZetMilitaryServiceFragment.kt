package com.team.ozet.views.zet.military_service

import android.util.Log
import android.view.View
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetMilitaryServiceBinding
import com.team.ozet.views.dialog.SelectorBottomDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import okhttp3.internal.userAgent
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetMilitaryServiceFragment : BaseFragment<FragmentZetMilitaryServiceBinding>(R.layout.fragment_zet_military_service) {
    private val viewModel:ZetMilitaryServiceViewModel by viewModel()
    private val args:ZetMilitaryServiceFragmentArgs by  navArgs()

    override fun init() {
        binding.vm = viewModel
        viewModelCallback()
        viewModel.setMilitary(args.military)
    }

    private fun viewModelCallback() {
        with(viewModel){
            clickSelector.observe(this@ZetMilitaryServiceFragment, Observer {
                showBottomSheet()
            })
            backClick.observe(this@ZetMilitaryServiceFragment, Observer {
                findNavController().popBackStack()
            })

        }
    }


    // todo 하드코딩한거 이전 해야함
    private fun showBottomSheet(){
        var bottomDialog = SelectorBottomDialog(dialogClick = {
            binding.tvMilitarySelector.apply{

                when(it){
                    "군필" -> {
                        viewModel.setVisible(true,false)
                    }

                    "미필" -> {
                        viewModel.setVisible(false,true)
                    }

                    "면제" -> {
                        viewModel.setVisible(false,false)
                    }

                    "해당없음" -> {
                        viewModel.setVisible(false,false)
                    }
                }
                text = it
            }
        },"직급 선택", arrayListOf("군필","미필","면제","해당없음"))
        bottomDialog.show(requireActivity().supportFragmentManager,"tag")
    }

}