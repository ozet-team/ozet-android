package com.team.ozet.views.onbording

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R

class OnbordingFragment : Fragment() {

    companion object {
        fun newInstance() = OnbordingFragment()
    }

    private lateinit var viewModel: OnbordingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onbording, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OnbordingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}