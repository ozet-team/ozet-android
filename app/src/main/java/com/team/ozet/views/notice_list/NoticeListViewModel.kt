package com.team.ozet.views.notice_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.utils.SingleLiveEvent

class NoticeListViewModel : BaseViewModel() {

    private val _go = SingleLiveEvent<Unit>()
    val go : LiveData<Unit> get() = _go

    fun go(){
        _go.call()
    }

}