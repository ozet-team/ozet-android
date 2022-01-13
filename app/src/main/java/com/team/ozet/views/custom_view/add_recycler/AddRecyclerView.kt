package com.team.ozet.views.custom_view.add_recycler

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.CustomAddRecyclerviewBinding

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
        addAdapter = AddAdapter()

        binding.rv.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = addAdapter
            setRecyclerListener {
            }
        }

        if (addAdapter.itemCount == 0){
            binding.apply {
                rv.visibility = View.GONE
                tvSub.visibility = View.GONE
                btnAdd.visibility = View.VISIBLE
            }
        }else{
            binding.apply {
                rv.visibility = View.VISIBLE
                tvSub.visibility = View.VISIBLE
                btnAdd.visibility = View.GONE
            }
        }

    }


    private fun getAttrs(attrs: AttributeSet?,defStyleAttr: Int){
        val typedArray:TypedArray =  context.obtainStyledAttributes(attrs,R.styleable.add_recycler,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.tvTitle.text = typedArray.getString(R.styleable.add_recycler_ar_title)
        var sub = typedArray.getString(R.styleable.add_recycler_ar_sub_title)
        when(sub){
            null -> binding.tvSub.visibility = View.GONE
            "" -> binding.tvSub.visibility = View.GONE
            else -> binding.tvSub.apply {
                visibility = View.VISIBLE
                text = sub
            }
        }

    }


    fun rv(): RecyclerView {
        return binding.rv
    }

    fun btnAdd(): Button {
        return binding.btnAdd
    }

    fun setItems(list : List<ZetSimple>) {
        if(list.size != 0){
            binding.apply {
                rv.visibility = View.VISIBLE
                tvSub.visibility = View.VISIBLE
                btnAdd.visibility = View.GONE
            }
        }else{
            binding.apply {
                rv.visibility = View.GONE
                tvSub.visibility = View.GONE
                btnAdd.visibility = View.VISIBLE
            }
        }
        addAdapter.setItmes(list)
    }

    fun tvSub(): TextView {
        return binding.tvSub
    }

    fun adapter(): AddAdapter {
        return addAdapter
    }

}