package com.team.ozet.views.zet.address

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class ZetAddressFragment : Fragment() {

    companion object {
        fun newInstance() = ZetAddressFragment()
    }

    private lateinit var viewModel: ZetAddressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zet_address, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZetAddressViewModel::class.java)
        // TODO: Use the ViewModel
    }

}