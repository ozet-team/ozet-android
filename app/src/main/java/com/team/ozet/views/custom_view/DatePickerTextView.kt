package com.team.ozet.views.custom_view

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.team.ozet.R
import com.team.ozet.databinding.CustomDatePickerTextBinding
import com.team.ozet.databinding.CustomDefaultEditTextBinding
import java.util.*

class DatePickerTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomDatePickerTextBinding>(
        LayoutInflater.from(context),R.layout.custom_date_picker_text,this,true
    )

    init {
        getAttrs(attrs, defStyleAttr)
        datePickerSet()
    }


//    private fun getAttrs(attrs: AttributeSet?){
//       val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.input_component)
//        setTypeArray(typedArray)
//    }

    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.date_picker_text,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.tvTitle.apply {
//            text = typedArray.getString(R.styleable.date_picker_text_tv_title)
            var tvVisibility = typedArray.getBoolean(R.styleable.default_edit_text_tv_visibility,true)
            if(tvVisibility){
                visibility = View.VISIBLE
            }else{
                visibility = View.GONE
            }
        }


    }

    private fun datePickerSet(){

        binding.tvDate.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            DatePickerDialog(
                context,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
                    val currentDate =
                        Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
                    // ...
                    var month = monthOfYear + 1
                    binding.tvDate.text = "${year.toString()}.${month.toString()}"


                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }

    fun showDatePickerDialog() {

    }
}