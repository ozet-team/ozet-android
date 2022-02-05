package com.team.ozet.views.zet.career

import android.os.Build
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.TextView
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
        appbarOnClick()
        viewModel.setCareerData(args.career)
        setTextViewHtml(binding.cmDefaultWorkplace.tvTitle(),getString(R.string.zet_career_workplace))
    }

    private fun viewModelCallback() {
        with(viewModel){
            clickPosition.observe(this@ZetCareerFragment, Observer {
                showBottomSheet()
            })
            backClick.observe(this@ZetCareerFragment, Observer {
                findNavController().popBackStack()
            })
            showToast.observe(this@ZetCareerFragment, Observer {
                showToast(it)
            })

        }
    }



    private fun appbarOnClick() {
        val token =
            "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
                    ".fBx1QnFXjnQRD1qqahJWoGWYtmJRMXQofZAFjwsn0wk"
        binding.appbar.tvSubFirst().setOnClickListener {
            // todo SharedPreferences 사용해야함
            if (viewModel.isCreate.value == true){
                viewModel.createCareer(token)
            }else{
                viewModel.updateCareer(token)
            }
        }
        binding.appbar.tvSubSecond().setOnClickListener {
            viewModel.deleteCareer(token)
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