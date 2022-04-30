package com.team.ozet.views.web_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.utils.SingleLiveEvent

class NoticeWebViewModel : ViewModel() {

    private val _go = SingleLiveEvent<Unit>()
    val go : LiveData<Unit> get() = _go

    fun go(){
        _go.call()
    }
}