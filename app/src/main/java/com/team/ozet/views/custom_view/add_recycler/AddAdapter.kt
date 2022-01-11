package com.team.ozet.views.custom_view.add_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.ItemAddRecyclerViewBinding
import com.team.ozet.databinding.ItemNoticeBinding

class AddAdapter (
        private val context:Context
        ): RecyclerView.Adapter<AddAdapter.ViewHolder>() {
    private val items:ArrayList<ZetSimple> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemAddRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != null || position != 0 ){
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (private val binding: ItemAddRecyclerViewBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:ZetSimple){
                    binding.apply {
                        tvContent.text = item.content
                        tvSub.text  = item.sub
                    }

                }


    }

    // viewDatabindingAdapters 를 위한 함수 3
    fun addItems(items: List<ZetSimple>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: ZetSimple) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }




}