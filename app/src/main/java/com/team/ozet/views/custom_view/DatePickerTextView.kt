package com.team.ozet.views.custom_view

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
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
            hint = typedArray.getString(R.styleable.date_picker_text_tv_date_hint)

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
                isEnabled = false


            }else{
                text = "YYYY.DD"
                isEnabled = true

            }
        }

    }

    private fun yearMonth(){
        val dialog = YearMonthPickerDialog {year, month ->

            binding.tvDate.text = "${year.toString()}-${DecimalFormat("00").format(month)}"
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
            }
        }

        dialog.show((context as FragmentActivity).supportFragmentManager, "tag")
        //todo 기존 날짜가 있다면 기존날짜로 선택되서 보여줘야함
//        if (!binding.tvDate.equals("") &&
//            !binding.tvDate.equals("YYYY.MM")){
//            var yearMonth = binding.tvDate.text.split("-")
////            dialog.setDate(yearMonth[0].toInt(),yearMonth[1].toInt())
//            dialog.getNpMonth().value = yearMonth[1].toInt()
//            dialog.getNpYear().value = yearMonth[0].toInt()
//
//        }
    }

    private fun basicDatePicker(){
        val calendar: Calendar = Calendar.getInstance()
           var date = DatePickerDialog(
                context,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // 선택된 날짜가 필요하면 이 currentDate 변수를 적절하게 사용하면 된다.
                    val currentDate =
                        Calendar.getInstance().apply { set(year, monthOfYear, dayOfMonth) }
                    // ...
                    var month = monthOfYear + 1
                    binding.tvDate.text = "${year.toString()}-" +
                            "${DecimalFormat("00").format(month)}-" +
                            "${DecimalFormat("00").format(dayOfMonth)}"
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
                    }


                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)

            )

//        var min = Calendar.getInstance()
//        min.set(2018,2-1,0);
//        date.datePicker.minDate = min.time.time
        date.show()

    }

    public fun getText(): CharSequence? {
        return binding.tvDate.text
    }


    object DefaultEditAdapter{
        @JvmStatic
        @BindingAdapter("app:tv_date")
        fun setText(view:DatePickerTextView,str:String){
            if (!str.equals("YYYY.MM")){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.binding.tvDate.setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
                }
            }
            view.binding.tvDate.text = str
        }
        @JvmStatic
        @BindingAdapter("tvDateChanged")
        fun setEtInputBindingListener(view: DatePickerTextView, listener: InverseBindingListener?) {
            val watcher = object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun afterTextChanged(editable: Editable) {
                    listener?.onChange()
                }
            }
            view.binding.tvDate.addTextChangedListener(watcher)
        }
        //*study*
        //InverseBindingAdpater 메서드는 역으로 레이아웃의 사용자 정의 속성값이 변경되었을 때 뷰 모델 등과 같은
        //레이아웃 변수에 변경 사항을 전달하여 양방향 바인딩이 구현될 수 있게 한다.
        @InverseBindingAdapter(attribute = "app:tv_date",event = "tvDateChanged")
        @JvmStatic
        fun getEtInput(view: DatePickerTextView): String {
            return view.binding.tvDate.text.toString()
        }

    }
}