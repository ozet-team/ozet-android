package com.team.ozet.views.custom_view.add_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.R
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.ItemAddRecyclerViewBinding
import com.team.ozet.databinding.ItemNoticeBinding

class AddAdapter (): RecyclerView.Adapter<AddAdapter.ViewHolder>() {
    private val items:ArrayList<ZetSimple> = ArrayList()

    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemAddRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != null || position != 0 ){
            holder.bind(items[position],position)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (private val binding: ItemAddRecyclerViewBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (item:ZetSimple,position: Int){
                    binding.apply {
                        tvContent.text = item.content
                        tvSub.text  = item.sub
                        cl.setOnClickListener {
                            itemClickListener.onClick(position)
                        }
                    }

                }


    }

    // viewDatabindingAdapters 를 위한 함수 3
    fun addItems(items: List<ZetSimple>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setItmes(item:List<ZetSimple>){
        this.items.clear()
        items.addAll(item)
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