package com.team.ozet.views.zet.introduce

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class ZetIntroduceFragment : Fragment() {

    companion object {
        fun newInstance() = ZetIntroduceFragment()
    }

    private lateinit var viewModel: ZetIntroduceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zet_introduce, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZetIntroduceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}