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
    private val _zetSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _resume = MutableLiveData<Resume>()

    val zetSimpleList:LiveData<List<ZetSimple>> get() = _zetSimpleList
    val resume:LiveData<Resume> get() = _resume

    fun setSimpleList(){
        var list = arrayListOf<ZetSimple>()

        for(i in 1..3){

            list.add(ZetSimple("1$i","3$i"))

        }
        list.toList()
        _zetSimpleList.value = list
    }

    fun getResume(){
        val token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5LCJ1c2VybmFtZSI6Im96ZXRfZDE2MDY2ZjA5YjU5NDI3NmJiN2Q5NjI4ZTVlYTE1NjQiLCJleHAiOjE2NDMxNzAwMjl9.AiU_nUBPmUXUVweYM_ESRrBCbZtWuyafg6H9gW_bJ5o"
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

}