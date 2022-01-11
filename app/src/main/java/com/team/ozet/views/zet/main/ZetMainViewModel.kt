package com.team.ozet.views.zet.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.zet.ZetSimple

class ZetMainViewModel : BaseViewModel() {
    private val _zetSimpleList = MutableLiveData<List<ZetSimple>>()

    val zetSimpleList:LiveData<List<ZetSimple>> get() = _zetSimpleList

    fun setSimpleList(){
        var list = arrayListOf<ZetSimple>()

        for(i in 1..3){

            list.add(ZetSimple("1$i","3$i"))

        }
        list.toList()
        _zetSimpleList.value = list

    }

}