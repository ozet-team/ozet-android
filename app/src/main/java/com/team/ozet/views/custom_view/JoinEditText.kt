package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.team.ozet.R
import com.team.ozet.databinding.CustomDefaultEditTextBinding
import com.team.ozet.databinding.CustomJoinEditTextBinding


class JoinEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomJoinEditTextBinding>(
        LayoutInflater.from(context), R.layout.custom_join_edit_text, this, true
    )

    init {
        getAttrs(attrs, defStyleAttr)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.join_edit_text, defStyleAttr, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
        binding.tvJoinTitle.apply {
            text = typedArray.getString(R.styleable.join_edit_text_tv_join_title)
            var tvVisibility =
                typedArray.getBoolean(R.styleable.default_edit_text_tv_visibility, true)
            if (tvVisibility) {
                visibility = View.VISIBLE
            } else {
                visibility = View.GONE
            }
            binding.etBase.apply {
                hint = typedArray.getString(R.styleable.join_edit_text_et_join_hint)
                inputType =
                    typedArray.getInt(R.styleable.default_edit_text_android_inputType, 0x00000001)
            }
        }
    }

    public fun getEditText():Editable?{
        return  binding.etBase.text
    }

    public fun setEditText(text:String){
//        binding.etBase.text = text
    }
}