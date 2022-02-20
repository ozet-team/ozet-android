package com.team.ozet.views.zet.certificate

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCertificateBinding
import com.team.ozet.utils.Test
import com.team.ozet.views.custom_view.CustomToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetCertificateFragment : BaseFragment<FragmentZetCertificateBinding>(R.layout.fragment_zet_certificate) {
    private val args: ZetCertificateFragmentArgs by navArgs()
    private val viewModel:ZetCertificateViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
        viewModelCallback()
        appbarOnClick()
        viewModel.setCertificateData(args.certificate)
        setTextViewHtml(binding.cmCertificateName.tvTitle(),getString(R.string.zet_certificate_name))
    }

    private fun viewModelCallback() {
        with(viewModel){

            backClick.observe(this@ZetCertificateFragment, Observer {
                findNavController().popBackStack()
            })
            showToast.observe(this@ZetCertificateFragment, Observer {
                val y = viewLocationOnScreen(binding.appbar)
                CustomToast.createToast(thisContext,it,y).show()
            })
        }
    }

    private fun appbarOnClick() {

        binding.appbar.tvSubFirst().setOnClickListener {
            // todo SharedPreferences 사용해야함

            if (viewModel.isCreate.value == true){
                viewModel.createCertificate(Test.testToken)
            }else{
                viewModel.updateCertificate(Test.testToken)
            }
        }
        binding.appbar.tvSubSecond().setOnClickListener {
            viewModel.deleteCertificate(Test.testToken)
        }

    }

}