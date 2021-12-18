package com.team.ozet.views.custom_view

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.team.ozet.R
import com.team.ozet.databinding.CustomDatePickerTextBinding
import com.team.ozet.databinding.CustomTextInfoBinding
import com.team.ozet.views.dialog.YearMonthPickerDialog
import java.text.DecimalFormat
import java.util.*

class InfoTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomTextInfoBinding>(
        LayoutInflater.from(context),R.layout.custom_text_info,this,true
    )

    init {
        getAttrs(attrs, defStyleAttr)
    }



    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.info_text,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.tvTitle.text = typedArray.getString(R.styleable.info_text_info_title)

        binding.tvContent.text = typedArray.getString(R.styleable.info_text_info_content)

    }





}