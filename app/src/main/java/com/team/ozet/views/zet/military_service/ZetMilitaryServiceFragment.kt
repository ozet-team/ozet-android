package com.team.ozet.views.zet.military_service

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentZetMilitaryServiceBinding

class ZetMilitaryServiceFragment : BaseFragment<FragmentZetMilitaryServiceBinding>(R.layout.fragment_zet_military_service) {
    override fun init() {
        noRadioGroupHandler()
    }


    private fun noRadioGroupHandler(){
        binding.rbFinish.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbYet.isChecked = false
                    rbExemption.isChecked = false
                    cmMilitaryDay.visibility = View.VISIBLE
                    cmMilitaryDayEnd.visibility = View.VISIBLE
                    cmExemption.visibility = View.GONE
                }

            }
        }
        binding.rbYet.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbFinish.isChecked = false
                    rbExemption.isChecked = false
                    cmMilitaryDay.visibility = View.GONE
                    cmMilitaryDayEnd.visibility = View.GONE
                    cmExemption.visibility = View.GONE
                }
            }
        }
        binding.rbExemption.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbYet.isChecked = false
                    rbFinish.isChecked = false
                    cmMilitaryDay.visibility = View.GONE
                    cmMilitaryDayEnd.visibility = View.GONE
                    cmExemption.visibility = View.VISIBLE
                }
            }
        }


    }
}