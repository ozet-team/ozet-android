package com.team.ozet.views.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.team.ozet.R
import com.team.ozet.data.announcement.AnnouncementList
import com.team.ozet.data.announcement.AnnouncementModel
import com.team.ozet.databinding.ItemNoticeBinding

class NoticeInfoAdapter (
    private val itemHandler: ItemHandler,
        ): RecyclerView.Adapter<NoticeInfoAdapter.ViewHolder>() {
    private var items: AnnouncementList = AnnouncementList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.list[position])
    }

    override fun getItemCount(): Int = items.list.size

    inner class ViewHolder (private val binding: ItemNoticeBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:AnnouncementModel){
                    binding.apply {
                        if (item.bookmarkCount == 0){
                            binding.ivBookmark.setImageResource(R.drawable.bookmark_icactive_)

                        }else{
                            binding.ivBookmark.setImageResource(R.drawable.bookmark_active_)
                        }


                        binding.ivImg.load(item.imageUrl)
                        binding.tvTitle.text = item.title
                        binding.tvShopName.text = item.shopName
                        binding.tvShopLocation.text = item.shopLocation

                        binding.cl.setOnClickListener {
                            itemHandler.clickNotice(NoticeEvent.DETAIL_CLICK,item.id)
                        }
                        binding.cvBookmark.setOnClickListener {
                            itemHandler.clickNotice(NoticeEvent.BOOKMARK_CLICK,item.id)
                        }
                    }

                }

    }

    interface ItemHandler {
        fun clickNotice(event: NoticeEvent,noticeId :Int)

    }

    fun addItems(items:  AnnouncementList) {
        this.items = items
        notifyDataSetChanged()
    }




}