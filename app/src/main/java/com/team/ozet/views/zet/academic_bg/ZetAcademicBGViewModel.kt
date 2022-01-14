package com.team.ozet.views.zet.academic_bg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.Academic

class ZetAcademicBGViewModel : BaseViewModel() {

    private val _academic = MutableLiveData<Academic>()

    val academic:LiveData<Academic> = _academic

    fun setAcademicData(data:Academic){
        if (data.joinAt.equals("")){
            data.joinAt ="YYYY.MM"
        }
        if (data.quitAt.equals("")){
            data.quitAt = "YYYY.MM"
        }
        _academic.value = data
    }

}