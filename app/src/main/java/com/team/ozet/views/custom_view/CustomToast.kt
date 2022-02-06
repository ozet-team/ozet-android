package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.team.ozet.R
import com.team.ozet.databinding.CustomToastBasicBinding

object CustomToast {

    fun createToast(context: Context, message: String, y: Int): Toast {
        val inflater = LayoutInflater.from(context)
        val binding: CustomToastBasicBinding =
            DataBindingUtil.inflate(inflater, R.layout.custom_toast_basic, null, false)

        binding.tvMessage.text = message

        return Toast(context).apply {
            var cl = ConstraintLayout(context)
            cl.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            setGravity(Gravity.TOP or Gravity.CENTER or Gravity.FILL_HORIZONTAL, 0, y.toPx())
            duration = Toast.LENGTH_SHORT
            view = binding.root
        }
    }

    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}

