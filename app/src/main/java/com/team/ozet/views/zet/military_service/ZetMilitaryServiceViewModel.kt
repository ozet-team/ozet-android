package com.team.ozet.views.zet.military_service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.Career
import com.team.ozet.data.resume.Military
import com.team.ozet.data.resume.Resume
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.utils.SingleLiveEvent

class ZetMilitaryServiceViewModel : BaseViewModel() {
    private val _military = MutableLiveData<Military>()
    private val _exemptionVisible = MutableLiveData<Boolean>()
    private val _finishedVisible = MutableLiveData<Boolean>()

    val military: LiveData<Military> get() = _military
    val exemptionVisible :LiveData<Boolean> get() =_exemptionVisible
    val finishedVisible : LiveData<Boolean> get() = _finishedVisible


    private val _clickSelector = SingleLiveEvent<Unit>()



    val clickSelector :LiveData<Unit> get() = _clickSelector

    fun clickSelector(){
        _clickSelector.call()
    }

    fun setVisible(finished:Boolean,exemption:Boolean){
        _finishedVisible.value = finished
        _exemptionVisible.value = exemption
    }

    fun setMilitary(military:Military){
        _military.value = military
        when(military.service){
            "군필" -> {
                _finishedVisible.value = true
                _exemptionVisible.value = false
            }

            "미필" -> {
                _finishedVisible.value = false
                _exemptionVisible.value = true
            }

            "면제" -> {
                _finishedVisible.value = false
                _exemptionVisible.value = false
            }

            "해당없음" -> {
                _finishedVisible.value = false
                _exemptionVisible.value = false
            }
        }

    }


}