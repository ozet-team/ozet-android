package com.team.ozet.views.zet.career

import android.util.Log
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
        binding.includeAppbar.tvTitle.text = "경력"
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
            clickDone.observe(this@ZetCareerFragment, Observer {
                val shopName = binding.cmDefaultShopName.getEditText()
                val startWork = binding.cmDateStartWork.getText()
                val endWork = binding.cmDateEndWork.getText()
                val position = binding.tvPosition.text
                val workResult = binding.cmDefaultResultWork.getEditText()
//                findNavController().navigate(R.id.action_zetCareerFragment_to_zetCertificateFragment)

            })
        }
    }


    private fun checkWorking(){
        binding.scCheckWork.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cmDateEndWork.checkWorking(isChecked,binding.scCheckWork.text.toString())
        }
    }

    fun positionSelector(){
        val bottomSheetView = layoutInflater.inflate(R.layout.dialog_position_selector,null)

        val bottomSheetDialog = BottomSheetDialog(thisContext)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }
}