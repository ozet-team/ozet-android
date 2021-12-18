package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseViewModel
import com.team.ozet.databinding.CustomAppbarBinding
import io.reactivex.Single


class DefaultAppbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?  = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomAppbarBinding>(
        LayoutInflater.from(context),R.layout.custom_appbar,this,true
    )

    init{
        getAttrs(attrs, defStyleAttr)
    }

    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray = context.obtainStyledAttributes(attrs,R.styleable.default_appbar,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
        binding.apply {

            imageView.setImageResource(
                typedArray.getResourceId(R.styleable.default_appbar_srcCompat,-1)
            )
            binding.imageView.setOnClickListener {
                findNavController().popBackStack()
            }

            tvTitle.text = typedArray.getText(R.styleable.default_appbar_tv_appbar_title)

            tvSubTitle.text = typedArray.getText(R.styleable.default_appbar_tv_appbar_sub_title)
            tvSubTitle.setTextColor(typedArray.getColor(R.styleable.default_appbar_android_textColor, Color.BLACK))
        }
    }


}