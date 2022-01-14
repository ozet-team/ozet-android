package com.team.ozet.views.zet.sns

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class ZetSNSFragment : Fragment() {

    companion object {
        fun newInstance() = ZetSNSFragment()
    }

    private lateinit var viewModel: ZetSNSViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zet_s_n_s, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZetSNSViewModel::class.java)
        // TODO: Use the ViewModel
    }

}