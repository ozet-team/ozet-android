package com.team.ozet.views.zet.career

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCareerBinding
import com.team.ozet.views.dialog.SelectorBottomDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetCareerFragment : BaseFragment<FragmentZetCareerBinding>(R.layout.fragment_zet_career) {
    val viewModel:ZetCareerViewModel by viewModel()
    private val args: ZetCareerFragmentArgs by navArgs()

    override fun init() {
        binding.vm = viewModel
        viewModelCallback()
        checkWorking()
        viewModel.setCareerData(args.career)
    }

    private fun viewModelCallback() {
        with(viewModel){
            clickPosition.observe(this@ZetCareerFragment, Observer {
                showBottomSheet()
            })
            backClick.observe(this@ZetCareerFragment, Observer {
                findNavController().popBackStack()
            })
        }
    }


    private fun checkWorking(){
        binding.scCheckWork.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cmDateEndWork.checkWorking(isChecked,binding.scCheckWork.text.toString())
        }
    }

    fun clickDone(){

    }

    // todo 하드코딩한거 이전 해야함
    private fun showBottomSheet(){
        var bottomDialog = SelectorBottomDialog(dialogClick = {
            binding.tvPosition.apply{
                text = it
            }
        },"직급 선택", arrayListOf("인턴(스탭)","매니저","디자이너","원장"))
        bottomDialog.show(requireActivity().supportFragmentManager,"tag")
    }

}