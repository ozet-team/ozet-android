package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
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

            imgBtn.setImageResource(
                typedArray.getResourceId(R.styleable.default_appbar_srcCompat,-1)
            )
            binding.imgBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            tvTitle.text = typedArray.getText(R.styleable.default_appbar_tv_appbar_title)

            var first = typedArray.getString(R.styleable.default_appbar_tv_appbar_sub_first)
            when(first){
                null -> tvSubFirst.visibility = View.GONE
                "" -> tvSubFirst.visibility = View.GONE
                else -> tvSubFirst.visibility = View.VISIBLE
            }

            var second = typedArray.getString(R.styleable.default_appbar_tv_appbar_sub_second)
            when(second){
                null -> tvSubSecond.visibility = View.GONE
                "" -> tvSubSecond.visibility = View.GONE
                else -> tvSubSecond
                    .visibility = View.VISIBLE
            }
            tvSubFirst.text = first
            tvSubFirst.setTextColor(typedArray.getColor(R.styleable.default_appbar_tv_appbar_sub_first_color, Color.BLACK))
            tvSubSecond.text = second
            tvSubSecond.setTextColor(typedArray.getColor(R.styleable.default_appbar_tv_appbar_sub_second_color, Color.BLACK))

        }
    }



    fun tvSubFirst(): TextView {
        return binding.tvSubFirst
    }

    fun tvSubSecond(): TextView {
        return binding.tvSubSecond
    }

}