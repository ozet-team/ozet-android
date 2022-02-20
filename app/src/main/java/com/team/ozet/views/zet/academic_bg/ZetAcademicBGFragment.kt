package com.team.ozet.views.zet.academic_bg

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetAcademicBgBinding
import com.team.ozet.utils.Test
import com.team.ozet.views.custom_view.CustomToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetAcademicBGFragment :
    BaseFragment<FragmentZetAcademicBgBinding>(R.layout.fragment_zet_academic_bg) {
    private val viewModel: ZetAcademicBGViewModel by viewModel()
    private val args: ZetAcademicBGFragmentArgs by navArgs()

    override fun init() {
        binding.vm = viewModel
        appbarOnClick()
        checkWorking()
        viewModelCallBak()
        viewModel.setAcademicData(args.academic)
        setTextViewHtml(binding.cmAcademicName.tvTitle(), getString(R.string.zet_academic_name))
    }

    private fun viewModelCallBak() {
        with(viewModel){
            showToast.observe(this@ZetAcademicBGFragment, Observer {
                val y = viewLocationOnScreen(binding.appbar)
                CustomToast.createToast(thisContext,it,y).show()
            })
        }
    }

    private fun appbarOnClick() {

        binding.appbar.tvSubFirst().setOnClickListener {
            // todo SharedPreferences 사용해야함
            if (viewModel.isCreate.value == true){
                viewModel.createAcademic(Test.testToken)
            }else{
                viewModel.updateAcademic(Test.testToken)
            }
        }
        binding.appbar.tvSubSecond().setOnClickListener {
            viewModel.deleteAcademic(Test.testToken)
        }

    }


    private fun checkWorking() {
        binding.scCheckAttending.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cmAcademicDayEnd.checkWorking(
                isChecked,
                binding.scCheckAttending.text.toString()
            )
        }
    }
}