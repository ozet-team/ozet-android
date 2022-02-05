package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
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
        setTypeArrayText(typedArray)
        setTypeArrayEdit(typedArray)
    }


    private fun setTypeArrayEdit(typedArray: TypedArray) {
        binding.etInput.apply {

            var single: Boolean =
                typedArray.getBoolean(R.styleable.default_edit_text_et_single_line, true)
            var etBackground: Boolean =
                typedArray.getBoolean(R.styleable.default_edit_text_et_background, true)

            isEnabled = typedArray.getBoolean(R.styleable.default_edit_text_et_enabled,true)

            inputType =
                typedArray.getInt(R.styleable.default_edit_text_android_inputType, 0x00000001)
            imeOptions =
                typedArray.getInt(R.styleable.default_edit_text_android_imeOptions, 0x00000005)
            hint = typedArray.getString(R.styleable.default_edit_text_et_input_hint)

            if (single) {
                isSingleLine = single
            } else {
                isSingleLine = single
            }
            if (etBackground) {
                background = context.getDrawable(R.drawable.bg_border_radius)
            } else {
                background = null
            }

        }
    }

    private fun setTypeArrayText(typedArray: TypedArray){
        binding.tvTitle.apply {
            text = typedArray.getString(R.styleable.default_edit_text_tv_title)
            var tvVisibility = typedArray.getBoolean(R.styleable.default_edit_text_tv_visibility,true)
            if(tvVisibility){
                visibility = View.VISIBLE
            }else{
                visibility = View.GONE
            }
        }
        }


    public fun tvTitle(): TextView {
        return binding.tvTitle
    }

    object DefaultEditAdapter{
        @JvmStatic
        @BindingAdapter("app:et_info_text")
        fun setEtText(view:DefaultEditText,text:String){
            view.binding.etInput.setText(text)
        }
        @JvmStatic
        @BindingAdapter("etInputChanged")
        fun setEtInputBindingListener(view: DefaultEditText, listener: InverseBindingListener?) {
            val watcher = object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun afterTextChanged(editable: Editable) {
                    listener?.onChange()
                }
            }
            view.binding.etInput.addTextChangedListener(watcher)
        }
        //*study*
        //InverseBindingAdpater 메서드는 역으로 레이아웃의 사용자 정의 속성값이 변경되었을 때 뷰 모델 등과 같은
        //레이아웃 변수에 변경 사항을 전달하여 양방향 바인딩이 구현될 수 있게 한다.
        @InverseBindingAdapter(attribute = "app:et_info_text",event = "etInputChanged")
        @JvmStatic
        fun getEtInput(view: DefaultEditText): String {
            return view.binding.etInput.text.toString()
        }

    }


}