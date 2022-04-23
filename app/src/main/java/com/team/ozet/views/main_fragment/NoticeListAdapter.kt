package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.announcement.AnnouncementList
import com.team.ozet.data.announcement.AnnouncementModel
import com.team.ozet.databinding.ItemNoticeBinding
import com.team.ozet.databinding.ItemNoticeListBinding

class NoticeListAdapter(
    items: ArrayList<AnnouncementList>,
    private val itemHandler: ItemHandler
        ): RecyclerView.Adapter<NoticeListAdapter.ViewHolder>() {
    private var items:ArrayList<AnnouncementList> = items

    private val noticeInfoItemHandler = object : NoticeInfoAdapter.ItemHandler {
        override fun clickNotice() {
          itemHandler.clickEvent(NoticeEvent.NOTICE_CLICK)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemNoticeListBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.bindAdapter(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (private val binding: ItemNoticeListBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:AnnouncementList){
                    binding.apply {
                        binding.tvNoticePlus.setOnClickListener { itemHandler.clickEvent(NoticeEvent.DETAIL_CLICK) }
                    }

                }
                fun bindAdapter(item:AnnouncementList){
                    var adapter = NoticeInfoAdapter(noticeInfoItemHandler)

                    if (items.size != 0){
                        adapter.addItems(item)
                        binding.rvNotice.adapter = adapter
                    }
                }


    }

    fun interface ItemHandler {
        fun clickEvent(event: NoticeEvent)
    }

    fun addItems(items: ArrayList<AnnouncementList>) {
        this.items = (items)
        notifyDataSetChanged()
    }


}