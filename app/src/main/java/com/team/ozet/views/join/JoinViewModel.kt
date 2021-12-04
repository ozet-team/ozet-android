package com.team.ozet.views.join

import androidx.lifecycle.LiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.utils.SingleLiveEvent

class JoinViewModel : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()

    val clickEvent : LiveData<Unit> get() = _clickEvent

    fun click(){
        _clickEvent.call()
    }
}