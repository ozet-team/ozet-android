package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.team.ozet.R
import com.team.ozet.databinding.CustomDefaultEditTextBinding

class DefaultEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomDefaultEditTextBinding>(
        LayoutInflater.from(context),R.layout.custom_default_edit_text,this,true
    )

    init {
        getAttrs(attrs, defStyleAttr)
    }


//    private fun getAttrs(attrs: AttributeSet?){
//       val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.input_component)
//        setTypeArray(typedArray)
//    }

    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.default_edit_text,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.tvTitle.apply {
            text = typedArray.getString(R.styleable.default_edit_text_tv_title)
            var tvVisibility = typedArray.getBoolean(R.styleable.default_edit_text_tv_visibility,true)
            if(tvVisibility){
                visibility = View.VISIBLE
            }else{
                visibility = View.GONE
            }
        }
        binding.etInput.apply {

            var single:Boolean = typedArray.getBoolean(R.styleable.default_edit_text_et_single_line,true)
            var etBackground:Boolean = typedArray.getBoolean(R.styleable.default_edit_text_et_background,true)

            inputType = typedArray.getInt(R.styleable.default_edit_text_android_inputType,0x00000001)
            imeOptions = typedArray.getInt(R.styleable.default_edit_text_android_imeOptions,0x00000005)
            hint = typedArray.getString(R.styleable.default_edit_text_et_input_hint)

            if (single){
                isSingleLine = single
                Log.i("AAA","boolean $single")
            }else{
                Log.i("AAA","boolean $single")
                isSingleLine = single
            }
            if (etBackground){
                background = context.getDrawable(R.drawable.bg_border_radius)
            }else{
                background = null
            }


        }

    }

}