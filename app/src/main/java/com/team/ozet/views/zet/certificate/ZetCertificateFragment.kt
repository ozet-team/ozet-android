package com.team.ozet.views.zet.certificate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetCertificateBinding
import com.team.ozet.views.zet.academic_bg.ZetAcademicBGFragmentArgs
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetCertificateFragment : BaseFragment<FragmentZetCertificateBinding>(R.layout.fragment_zet_certificate) {
    private val args: ZetCertificateFragmentArgs by navArgs()
    private val viewModel:ZetCertificateViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
        viewModel.setCertificateData(args.certificate)
    }

}