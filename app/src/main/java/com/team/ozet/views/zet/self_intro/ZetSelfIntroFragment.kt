package com.team.ozet.views.zet.self_intro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class ZetSelfIntroFragment : Fragment() {

    companion object {
        fun newInstance() = ZetSelfIntroFragment()
    }

    private lateinit var viewModel: ZetSelfIntroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zet_self_intro, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZetSelfIntroViewModel::class.java)
        // TODO: Use the ViewModel
    }

}