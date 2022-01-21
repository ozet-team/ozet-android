package com.team.ozet.views.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.team.ozet.R
import com.team.ozet.databinding.DialogSelectorBottomBinding
import com.team.ozet.views.custom_view.add_recycler.AddAdapter

class SelectorBottomDialog(val dialogClick:(String) -> Unit, title: String, list:ArrayList<String>) : BottomSheetDialogFragment() {
    lateinit var selectorAdapter: SelectorAdapter
    lateinit var binding:DialogSelectorBottomBinding
    val strList = list
    val title = title
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_selector_bottom, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        selectorAdapter.setItmes(strList)
        binding.tvTitle.text = title

    }

    private fun initAdapter() {
        selectorAdapter = SelectorAdapter(itemClick = {
            dialogClick(it)
            dialog?.dismiss()
        })

        binding.rvSelection.apply {

            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = selectorAdapter
            setRecyclerListener {
            }
        }
    }
}