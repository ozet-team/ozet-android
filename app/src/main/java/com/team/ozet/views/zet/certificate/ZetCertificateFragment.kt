package com.team.ozet.views.zet.certificate

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCertificateBinding
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
                viewModel.createCertificate(token)
            }else{
                viewModel.updateCertificate(token)
            }
        }
        binding.appbar.tvSubSecond().setOnClickListener {
            viewModel.deleteCertificate(token)
        }

    }

}