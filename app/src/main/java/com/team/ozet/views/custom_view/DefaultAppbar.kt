package com.team.ozet.views.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseViewModel
import com.team.ozet.databinding.CustomAppbarBinding
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.Single


class DefaultAppbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?  = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var _firstClick = SingleLiveEvent<Unit>()
    val firstClick: LiveData<Unit> get() = _firstClick
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


            tvSubFirst.text = first
            tvSubFirst.setTextColor(typedArray.getColor(R.styleable.default_appbar_tv_appbar_sub_first_color, Color.BLACK))
            tvSubSecond.setTextColor(typedArray.getColor(R.styleable.default_appbar_tv_appbar_sub_second_color, Color.BLACK))

        }
    }



    fun tvSubFirst(): TextView {
        return binding.tvSubFirst
    }

    fun tvSubSecond(): TextView {
        return binding.tvSubSecond
    }


    object DefaultAppbarAdapter{
        @JvmStatic
        @BindingAdapter("tv_appbar_sub_second")
        fun setEtText(view:DefaultAppbar,text:String){
            view.binding.apply {
                when(text){
                    null -> tvSubSecond.visibility = View.GONE
                    "" -> tvSubSecond.visibility = View.GONE
                    else -> tvSubSecond.visibility = View.VISIBLE
                }
                tvSubSecond.text = text
            }

        }
        @JvmStatic
        @BindingAdapter("etInputChanged")
        fun setEtInputBindingListener(view: DefaultAppbar, listener: InverseBindingListener?) {
            val watcher = object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun afterTextChanged(editable: Editable) {
                    listener?.onChange()
                }
            }
            view.binding.tvSubSecond.addTextChangedListener(watcher)
        }
        //*study*
        //InverseBindingAdpater 메서드는 역으로 레이아웃의 사용자 정의 속성값이 변경되었을 때 뷰 모델 등과 같은
        //레이아웃 변수에 변경 사항을 전달하여 양방향 바인딩이 구현될 수 있게 한다.
        @InverseBindingAdapter(attribute = "tv_appbar_sub_second",event = "etInputChanged")
        @JvmStatic
        fun getEtInput(view: DefaultAppbar): String {
            return view.binding.tvSubSecond.text.toString()
        }


    }


}