package com.team.ozet.views.dialog

import android.os.Bundle
import android.view.*
import android.widget.NumberPicker
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.team.ozet.R
import com.team.ozet.databinding.DialogYearMonthPickerBinding
import java.text.DecimalFormat
import java.util.*

class YearMonthPickerDialog(val itemClick:(year:Int,month:Int) -> Unit) : DialogFragment(){
    lateinit var binding: DialogYearMonthPickerBinding
    var cal = Calendar.getInstance()
    private final val MAX_YEAR = 2040
    private final val MIN_YEAR = 1980

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_year_month_picker, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.npMonth.apply {
            minValue = 1
            maxValue = 12
            value = cal[Calendar.MONTH] + 1
            setFormatter {
                DecimalFormat("00").format(it)
            }
        }

        binding.npYear.apply {
            minValue = MIN_YEAR
            maxValue = MAX_YEAR
            value =  cal[Calendar.YEAR]
        }

        binding.btnCancel.setOnClickListener {
            dialog?.dismiss()
        }

        binding.btnDone.setOnClickListener {
            itemClick(binding.npYear.value,binding.npMonth.value)
            dialog?.dismiss()
        }
       var params: WindowManager.LayoutParams = dialog?.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog!!.window!!.attributes = params

    }

   fun setDate(year: Int,month: Int){
        lazy {
            binding.npYear.value = year
            binding.npMonth.value = month
        }
    }

    fun getNpYear(): NumberPicker =  binding.npYear
    fun getNpMonth(): NumberPicker =  binding.npMonth
}