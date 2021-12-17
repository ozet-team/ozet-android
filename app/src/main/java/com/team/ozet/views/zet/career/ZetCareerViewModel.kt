package com.team.ozet.views.zet.career

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.utils.SingleLiveEvent

class ZetCareerViewModel : BaseViewModel() {
    private val _clickPosition = SingleLiveEvent<Unit>()
    private val _clickDone = SingleLiveEvent<Unit>()

    val clickPosition :LiveData<Unit> get() = _clickPosition
    val clickDone :LiveData<Unit> get() = _clickDone

    fun clickPosition(){
        _clickPosition.call()
    }

    fun clickDone(){
        _clickDone.call()
    }


}