package com.team.ozet.views.zet.academic_bg

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetAcademicBgBinding
import com.team.ozet.utils.PreferenceManager
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
        setTextViewHtml(binding.cmAcademicName.tvTitle(),getString(R.string.zet_academic_name))
    }

    private fun viewModelCallBak() {
        with(viewModel){
            backClick.observe(this@ZetAcademicBGFragment, Observer {
                findNavController().popBackStack()
            })
            showToast.observe(this@ZetAcademicBGFragment, Observer {
                showToast(it)
            })
        }
    }

    private fun appbarOnClick() {
        val token =
            "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5LCJ1c2VybmFtZSI6Im96ZXRfZDE2MDY2ZjA5YjU5NDI3NmJiN2Q5NjI4ZTVlYTE1NjQiLCJleHAiOjE2NDQ2NTk1Njl9.fBx1QnFXjnQRD1qqahJWoGWYtmJRMXQofZAFjwsn0wk"
        binding.appbar.tvSubFirst().setOnClickListener {
            // todo SharedPreferences 사용해야함
            if (viewModel.isCreate.value == true){
                viewModel.createAcademic(token)
            }else{
                viewModel.updateAcademic(token)
            }
        }
        binding.appbar.tvSubSecond().setOnClickListener {
            viewModel.deleteAcademic(token)
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