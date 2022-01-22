package com.team.ozet.views.zet.military_service

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.MilitaryModel
import com.team.ozet.data.resume.repository.ResumeRepository
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetMilitaryServiceViewModel(private val resumeRepo: ResumeRepository) : BaseViewModel() {
    private val _military = MutableLiveData<MilitaryModel>()
    private val _exemptionVisible = MutableLiveData<Boolean>()
    private val _finishedVisible = MutableLiveData<Boolean>()

    val militaryModel: LiveData<MilitaryModel> get() = _military
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

    fun setMilitary(militaryModel:MilitaryModel){
        _military.value = militaryModel
        isCreate(militaryModel.id == 0)
        if (militaryModel.id == 0){
            setSecondText("")
        }else{
            setSecondText("삭제")
        }

        when(militaryModel.service){
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

    fun createMilitary(token: String){
        var body = militaryModel.value

        if (body != null) {

            /**
             * date format 은 일까지 있어야함
             */
            if (body.joinAt.equals("YYYY.MM")  ){
                body.joinAt = null
            }else{
                body.joinAt = "${body!!.joinAt}-01"
            }
            if (body.quitAt.equals("YYYY.MM") ){
                body.quitAt = null
            }else{
                body.quitAt = "${body!!.quitAt}-01"
            }

            compositeDisposable.add(
                resumeRepo.postMilitaryAdd(token,  body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onSuccess = {
                            onShowToast("저장 되었습니다.")
                            onBackClick()
                        },
                        onError = {
                            Log.e("Error", "$it")
                        }
                    )
            )
        }

    }

    fun updateMilitary(token: String) {
        var body = militaryModel.value
        if (body?.id != null) {
            compositeDisposable.add(
                resumeRepo.patchMilitaryUpdate(token, body.id, body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onSuccess = {
                            onShowToast("저장 되었습니다.")
                            onBackClick()
                        },
                        onError = {
                            Log.e("Error", "$it")
                        }
                    )
            )
        }
    }

    fun deleteMilitary(token: String) {
        var id = militaryModel.value?.id
        if (id != null) {
            compositeDisposable.add(
                resumeRepo.deleteMilitary(token, id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onComplete = {
                            onShowToast("삭제 되었습니다.")
                            onBackClick()
                        },
                        onError = {
                            Log.e("Error", "$it")
                        }
                    )
            )
        }

    }

}