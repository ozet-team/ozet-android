package com.team.ozet.views.zet.career

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCareerBinding
import com.team.ozet.views.dialog.PositionSelectorDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetCareerFragment : BaseFragment<FragmentZetCareerBinding>(R.layout.fragment_zet_career) {
    val viewModel:ZetCareerViewModel by viewModel()


    override fun init() {
        binding.vm = viewModel
        callback()
        checkWorking()
    }

    private fun callback() {
        with(viewModel){
            clickPosition.observe(this@ZetCareerFragment, Observer {
               val positionSelectorDialog = PositionSelectorDialog{
                binding.tvPosition.text = it
               }
                positionSelectorDialog.show(requireActivity().supportFragmentManager,"tag")
            })
            backClick.observe(this@ZetCareerFragment, Observer {
                Log.i("AAA","back click")
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

}