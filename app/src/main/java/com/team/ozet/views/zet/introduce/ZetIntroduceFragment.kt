package com.team.ozet.views.zet.introduce

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetIntroduceBinding
import com.team.ozet.utils.Test
import com.team.ozet.views.custom_view.CustomToast
import com.team.ozet.views.zet.address.ZetAddressFragmentArgs
import com.team.ozet.views.zet.address.ZetAddressViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetIntroduceFragment : BaseFragment<FragmentZetIntroduceBinding>(R.layout.fragment_zet_introduce) {
    private val viewModel: ZetIntroduceViewModel by viewModel()
    private val args: ZetAddressFragmentArgs by navArgs()

    override fun init() {
        binding.vm = viewModel
        appbarOnClick()
        viewModelCallBak()
        viewModel.setUserModelData(args.user)
        setTextViewHtml(binding.cmDefaultIntroduce.tvTitle(), getString(R.string.zet_introduce))
    }

    private fun viewModelCallBak() {
        with(viewModel){
            showToast.observe(this@ZetIntroduceFragment, Observer {
                val y = viewLocationOnScreen(binding.appbar)
                CustomToast.createToast(thisContext,it,y).show()
            })
        }

    }

    private fun appbarOnClick() {

        binding.appbar.tvSubFirst().setOnClickListener {
            // todo SharedPreferences 사용해야함

            viewModel.userUpdate(Test.testToken)

        }

    }


}