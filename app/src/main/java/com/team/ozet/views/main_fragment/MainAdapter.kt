package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.databinding.ItemMainBinding

class MainAdapter (var noticeAdapter: NoticeAdapter
        ): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder(private val binding:  ItemMainBinding):
            RecyclerView.ViewHolder(binding.root){



    }


    fun clear() {
        notifyDataSetChanged()
    }

}