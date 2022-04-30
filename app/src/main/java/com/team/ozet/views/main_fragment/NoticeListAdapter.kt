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
import com.team.ozet.utils.Web

class NoticeListAdapter(
    private val itemHandler: ItemHandler
        ): RecyclerView.Adapter<NoticeListAdapter.ViewHolder>() {
    private var items:ArrayList<AnnouncementList> = arrayListOf()
    private lateinit var adapter : NoticeInfoAdapter
    lateinit var event:NoticeEvent
    private val noticeInfoItemHandler = object : NoticeInfoAdapter.ItemHandler {
        override fun clickNotice(event: NoticeEvent,noticeId:Int) {
          itemHandler.clickEvent(event,noticeId)
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
                        binding.tvNotice.text = item.name


                        binding.tvNoticePlus.setOnClickListener {
                            when(item.name){
                                Web.WEB_ALL->{
                                    event = NoticeEvent.NOTICE_LIST_All_CLICK
                                }
                                Web.WEB_BOOKMARK ->{
                                    event = NoticeEvent.NOTICE_LIST_BOOKMARK_CLICK
                                }
                                Web.WEB_RECOMMEND ->{
                                    event = NoticeEvent.NOTICE_LIST_RECOMMEND_CLICK
                                }
                            }
                            itemHandler.clickEvent(event,0)
                        }
                    }

                }
                fun bindAdapter(item:AnnouncementList){
                    adapter = NoticeInfoAdapter(noticeInfoItemHandler)

                    if (items.size != 0){
                        adapter.addItems(item)
                        binding.rvNotice.adapter = adapter
                    }
                }


    }

    fun interface ItemHandler {
        fun clickEvent(event: NoticeEvent,noticeId: Int)
    }

    fun addItems(items: ArrayList<AnnouncementList>) {
        this.items = items
        notifyDataSetChanged()
    }
    fun noticeInfoNotify(){
        adapter.notifyDataSetChanged()
    }



}