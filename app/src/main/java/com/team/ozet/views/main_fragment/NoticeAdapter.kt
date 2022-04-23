package com.team.ozet.views.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.databinding.ItemMainNoticeBinding

class NoticeAdapter (
    private val loginClick : () -> Unit,
    private val noticeClick : () -> Unit
        ): RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(com.team.ozet.databinding.ItemMainNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder (private val binding: ItemMainNoticeBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind() {
            binding.ivMainLogin.setOnClickListener {
                loginClick()
            }
            binding.ivMainNotice.setOnClickListener {
                noticeClick()
            }
        }

    }




}