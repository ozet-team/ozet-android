package com.team.ozet.views.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.ItemAddRecyclerViewBinding
import com.team.ozet.databinding.ItemNoticeBinding
import com.team.ozet.databinding.ItemSelectorBinding

class SelectorAdapter ( private val itemClick: (str:String) -> Unit): RecyclerView.Adapter<SelectorAdapter.ViewHolder>() {
    private val items:ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemSelectorBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != null || position != 0 ){
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (private val binding: ItemSelectorBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:String){
                    binding.apply {
                        tvSelection.text = item
                        cl.setOnClickListener {
                            itemClick(item)
                        }
                    }

                }


    }

    // viewDatabindingAdapters 를 위한 함수 3
    fun addItems(items: List<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setItmes(item:List<String>){
        this.items.clear()
        items.addAll(item)
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