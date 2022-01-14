package com.team.ozet.views.zet.military_service

import android.view.View
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
                    rbNot.isChecked = false
                    cmDateMilitaryStart.visibility = View.VISIBLE
                    cmDateMilitaryEnd.visibility = View.VISIBLE
                    cmDefaultExemption.visibility = View.GONE
                    center.visibility = View.VISIBLE

                }

            }
        }
        binding.rbYet.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbFinish.isChecked = false
                    rbExemption.isChecked = false
                    rbNot.isChecked = false
                    cmDateMilitaryStart.visibility = View.GONE
                    cmDateMilitaryEnd.visibility = View.GONE
                    cmDefaultExemption.visibility = View.GONE
                    center.visibility = View.GONE
                }
            }
        }
        binding.rbExemption.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbYet.isChecked = false
                    rbFinish.isChecked = false
                    rbNot.isChecked = false
                    cmDateMilitaryStart.visibility = View.GONE
                    cmDateMilitaryEnd.visibility = View.GONE
                    cmDefaultExemption.visibility = View.VISIBLE
                    center.visibility = View.GONE
                }
            }
        }
        binding.rbNot.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.apply {
                    rbFinish.isChecked = false
                    rbExemption.isChecked = false
                    rbYet.isChecked = false
                    cmDateMilitaryStart.visibility = View.GONE
                    cmDateMilitaryEnd.visibility = View.GONE
                    cmDefaultExemption.visibility = View.GONE
                    center.visibility = View.GONE
                }
            }
        }


    }
}