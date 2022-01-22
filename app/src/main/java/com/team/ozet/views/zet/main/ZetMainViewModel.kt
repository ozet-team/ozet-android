package com.team.ozet.views.zet.main

import android.util.JsonToken
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.ResumeModel
import com.team.ozet.data.resume.repository.ResumeRepository
import com.team.ozet.data.user.UserModel
import com.team.ozet.data.user.repository.UserRepository
import com.team.ozet.data.zet.ZetSimple
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.merge

class ZetMainViewModel(
    private val resumeRepo: ResumeRepository,
    private val userRepo: UserRepository
) : BaseViewModel() {

    private val _acSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _carSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _cerSimpleList = MutableLiveData<List<ZetSimple>>()
    private val _resume = MutableLiveData<ResumeModel>()
    private val _user = MutableLiveData<UserModel>()

    val acSimpleList: LiveData<List<ZetSimple>> get() = _acSimpleList
    val carSimpleList: LiveData<List<ZetSimple>> get() = _carSimpleList
    val cerSimpleList: LiveData<List<ZetSimple>> get() = _cerSimpleList
    val resumeModel: LiveData<ResumeModel> get() = _resume
    val user:LiveData<UserModel> get() = _user

    fun getResume(token: String) {

        compositeDisposable.add(
            resumeRepo.getResume(token)
                .zipWith(userRepo.getUser(token), BiFunction{resume,user ->
                    _resume.postValue(resume)
                    _user.postValue(user)
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        Log.i("AAA","success")
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )

    }

    fun getUser(token: String){
        compositeDisposable.add(
            resumeRepo.getResume(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        _resume.value = it
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }

    // todo binding adapter 적용해야함
    fun setList() {
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