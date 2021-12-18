package com.team.ozet.views.custom_view.add_recycler

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.ozet.R
import com.team.ozet.databinding.CustomAddRecyclerviewBinding
import com.team.ozet.databinding.CustomTextInfoBinding
import com.team.ozet.views.main_fragment.NoticeAdapter

class AddRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var addAdapter: AddAdapter

    private var binding = DataBindingUtil.inflate<CustomAddRecyclerviewBinding>(
        LayoutInflater.from(context),R.layout.custom_add_recyclerview,this,true
    )

    init {
        getAttrs(attrs, defStyleAttr)
        initAdapter()

    }

    private fun initAdapter() {
        addAdapter = AddAdapter(context)

        binding.rv.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = addAdapter
            setRecyclerListener {
            }
        }

        if (addAdapter.itemCount == 0){
            binding.rv.visibility = View.GONE
            binding.btnAdd.visibility = View.VISIBLE
        }else{
            binding.rv.visibility = View.VISIBLE
            binding.btnAdd.visibility = View.GONE
        }

    }


    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.add_recycler,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.tvTitle.text = typedArray.getString(R.styleable.add_recycler_ar_title)
    }





}