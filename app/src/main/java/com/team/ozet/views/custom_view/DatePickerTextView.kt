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
import com.team.ozet.views.dialog.YearMonthPickerDialog
import java.text.DecimalFormat
import java.util.*

class DatePickerTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding = DataBindingUtil.inflate<CustomDatePickerTextBinding>(
        LayoutInflater.from(context),R.layout.custom_date_picker_text,this,true
    )

    init {
        getAttrs(attrs, defStyleAttr)
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
            text = typedArray.getString(R.styleable.date_picker_text_tv_title_name)
            var tvVisibility = typedArray.getBoolean(R.styleable.date_picker_text_tv_title_visibility,true)
            if(tvVisibility){
                visibility = View.VISIBLE
            }else{
                visibility = View.GONE
            }
        }
        binding.tvDate.apply {
            text = typedArray.getString(R.styleable.date_picker_text_tv_date_text)

        }

        datePickerSet(typedArray.getInt(R.styleable.date_picker_text_date_mode,0))
    }

//    mode 0: basic      mode 1 : year month
    private fun datePickerSet(mode:Int){
        binding.tvDate.setOnClickListener {
            when(mode){
                0 -> basicDatePicker()
                1 -> yearMonth()
            }
        }

    }

    public fun checkWorking(check:Boolean,content:String){
        binding.tvDate.apply {
            if (check){
                text = content
                //todo enabled  false 시 text color 설정 문제 있음
                isEnabled = false
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    setTextColor(context.getColor(R.color.text_selector))
                }

            }else{
                text = "YYYY.DD"
                isEnabled = true
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    binding.tvDate.setTextColor(context.getColor(R.color.system_gray02))
                }
            }
        }

    }

    private fun yearMonth(){
        val dialog = YearMonthPickerDialog {year, month ->

            binding.tvDate.text = "${year.toString()}.${DecimalFormat("00").format(month)}"
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
            }
        }
        dialog.show((context as FragmentActivity).supportFragmentManager, "tag")
    }

    private fun basicDatePicker(){
        val calendar: Calendar = Calendar.getInstance()
            DatePickerDialog(
                context,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
                    val currentDate =
                        Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
                    // ...
                    var month = monthOfYear + 1
                    binding.tvDate.text = "${year.toString()}." +
                            "${DecimalFormat("00").format(month)}." +
                            "${DecimalFormat("00").format(dayOfMonth)}"
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
                    }

                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()

//            DatePickerDialog(context,R.style.customDatePickerStyle,
//                    DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
//                        // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
//                        val currentDate =
//                                Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
//                        // ...
//                        var month = monthOfYear + 1
//                        binding.tvDate.text = "${year.toString()}.${month.toString()}"
//                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                            binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
//                        }
//
//                    },
//                    calendar.get(Calendar.YEAR),
//                    calendar.get(Calendar.MONTH),
//                    calendar.get(Calendar.DAY_OF_MONTH)
//            ).show()
    }

    public fun getText(): CharSequence? {
        return binding.tvDate.text
    }

}