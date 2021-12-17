package com.team.ozet.views.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.team.ozet.R
import com.team.ozet.databinding.DialogPositionSelectorBinding

class PositionSelectorDialog(val itemClick:(String) -> Unit) : BottomSheetDialogFragment() {
    lateinit var binding:DialogPositionSelectorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_position_selector, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo it get text
        binding.tvSelection1.setOnClickListener {
            itemClick(binding.tvSelection1.text.toString())
            dialog?.dismiss()
        }
        binding.tvSelection2.setOnClickListener {
            itemClick(binding.tvSelection2.text.toString())
            dialog?.dismiss()
        }
        binding.tvSelection3.setOnClickListener {
            itemClick(binding.tvSelection3.text.toString())
            dialog?.dismiss()
        }
        binding.tvSelection4.setOnClickListener {
            itemClick(binding.tvSelection4.text.toString())
            dialog?.dismiss()
        }


    }
}