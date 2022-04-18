package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.databinding.ItemMainNoticeBinding
import com.team.ozet.databinding.ItemNoticeBinding

class NoticeAdapter (
    private val loginClick : () -> Unit,
    private val noticeClick : () -> Unit
        ): RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemMainNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder (private val binding: ItemMainNoticeBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind() {
            binding.cvLogin.setOnClickListener {
                loginClick()
            }
            binding.cvNotice.setOnClickListener {
                noticeClick()
            }
        }

    }




}