package com.team.ozet.views.zet.certificate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class ZetCertificateFragment : Fragment() {

    companion object {
        fun newInstance() = ZetCertificateFragment()
    }

    private lateinit var viewModel: ZetCertificateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zet_certificate, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZetCertificateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}