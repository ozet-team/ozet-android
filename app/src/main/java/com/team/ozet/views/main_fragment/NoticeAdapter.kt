package com.team.ozet.views.main_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.databinding.ItemNoticeBinding

class NoticeAdapter (
        private val context:Context
        ): RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {
    private val items:ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (private val binding: ItemNoticeBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:String){
                    binding.apply {
                        tvTitle.text = item
                        cvBookmark.setOnClickListener {
                            // test 용
                            ivBookmark.setImageDrawable(context.getDrawable(R.drawable.bookmark_active_))

                        }
                    }

                }


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