package com.team.ozet.views.zet.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.Resume
import com.team.ozet.data.resume.repository.ResumeRepository
import com.team.ozet.data.zet.ZetSimple
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetMainViewModel(private val repository:ResumeRepository) : BaseViewModel() {
    private val _acSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _carSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _cerSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _resume = MutableLiveData<Resume>()

    val acSimpleList:LiveData<List<ZetSimple>> get() = _acSimpleList
    val carSimpleList:LiveData<List<ZetSimple>> get() = _carSimpleList
    val cerSimpleList:LiveData<List<ZetSimple>> get() = _cerSimpleList
    val resume:LiveData<Resume> get() = _resume

    fun getResume(){
        val token = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5LCJ1c2VybmFtZSI6Im96ZXRfZDE2MDY2ZjA5YjU5NDI3NmJiN2Q5NjI4ZTVlYTE1NjQiLCJleHAiOjE2NDMxNzAwMjl9.AiU_nUBPmUXUVweYM_ESRrBCbZtWuyafg6H9gW_bJ5o"
        compositeDisposable.add(
            repository.getResume(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                    onSuccess = {
                      _resume.value = it
                    },
                    onError = {
                        Log.e("Error","$it")
                    }
                )
        )
    }

// todo binding adapter 적용해야함
    fun setList(){
//        var acSimple = arrayListOf<ZetSimple>()
//        var carSimple = arrayListOf<ZetSimple>()
//        var cerSimple = arrayListOf<ZetSimple>()
//        for (i in it.academic){
//            acSimple.add(ZetSimple(i.major,"${i.joinAt} ~ ${i.quitAt}"))
//        }
//        for (i in it.career){
//            carSimple.add(ZetSimple(i.company,"${i.joinAt} ~ ${i.quitAt}"))
//        }
//        for (i in it.certificate){
//            cerSimple.add(ZetSimple(i.name,"${i.certificateAt}"))
//        }
//        _acSimpleList.value = acSimple
//        _cerSimpleList.value = cerSimple
//        _carSimpleList.value = carSimple
    }

}