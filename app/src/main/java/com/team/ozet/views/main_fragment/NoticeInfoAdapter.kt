package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.databinding.ItemNoticeBinding
import com.team.ozet.databinding.ItemNoticeListBinding

class NoticeInfoAdapter (
    private val itemHandler: ItemHandler,
        ): RecyclerView.Adapter<NoticeInfoAdapter.ViewHolder>() {
    private val items:ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 6

    inner class ViewHolder (private val binding: ItemNoticeBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (){
                    binding.apply {
                        binding.cl.setOnClickListener {
                            itemHandler.clickNotice()
                        }
                    }

                }

    }

    interface ItemHandler {
        fun clickNotice()
    }

    // viewDatabindingAdapters 를 위한 함수 3
    fun addItems(items: List<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: String) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }


}