package com.team.ozet.views.my_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.utils.SingleLiveEvent

class    MypageViewModel : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()

    val clickEvent: LiveData<Unit> get() = _clickEvent

    fun click() {
        _clickEvent.call()
    }
}