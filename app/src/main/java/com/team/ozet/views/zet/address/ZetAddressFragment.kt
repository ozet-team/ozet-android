package com.team.ozet.views.zet.address

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
import com.team.ozet.databinding.FragmentZetAddressBinding
import com.team.ozet.utils.Test
import com.team.ozet.views.custom_view.CustomToast
import com.team.ozet.views.zet.academic_bg.ZetAcademicBGFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetAddressFragment : BaseFragment<FragmentZetAddressBinding>(R.layout.fragment_zet_address) {
    private val viewModel:ZetAddressViewModel by viewModel()
    private val args: ZetAddressFragmentArgs by navArgs()

    override fun init() {
        binding.vm = viewModel
        appbarOnClick()
        viewModelCallBak()
        viewModel.setUserModelData(args.user)
        setTextViewHtml(binding.cmDefaultAddress.tvTitle(), getString(R.string.zet_address))
    }

    private fun viewModelCallBak() {
        with(viewModel){
            showToast.observe(this@ZetAddressFragment, Observer {
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