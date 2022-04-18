package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.announcement.AnnouncementList
import com.team.ozet.databinding.ItemNoticeBinding
import com.team.ozet.databinding.ItemNoticeListBinding

class NoticeListAdapter(
    items: AnnouncementList,
    private val goDetailClick: () -> Unit,
    private val itemHandler: ItemHandler
        ): RecyclerView.Adapter<NoticeListAdapter.ViewHolder>() {
    private val items:AnnouncementList = items

    private val noticeInfoItemHandler = object : NoticeInfoAdapter.ItemHandler {
        override fun clickNotice() {
          itemHandler.clickNotice()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemNoticeListBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.bindAdapter()
    }

    override fun getItemCount(): Int = 3

    inner class ViewHolder (private val binding: ItemNoticeListBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (){
                    binding.apply {
                        binding.tvNoticePlus.setOnClickListener { goDetailClick() }
                    }

                }
                fun bindAdapter(){
                    items.basicList
                    binding.rvNotice.adapter = NoticeInfoAdapter(noticeInfoItemHandler)
                }


    }

    fun interface ItemHandler {
        fun clickNotice()

    }




}