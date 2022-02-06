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
        isCreate(militaryModel.id == 1)

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

    fun updateMilitary(token: String) {
        var body:MilitaryModel = militaryModel.value!!

        // todo map 으로 관리 하는게 좋을듯
        when(body.service){
            "군필" -> {
                body.service = "FINISHED"
            }
            "미필" -> {
                body.service = "UNFINISHED"
            }

            "면제" -> {
                body.service = "EXEMPTION"
            }

            "해당없음" -> {
                body.service = "NA"
            }
            "" ->{
                Log.i("AAA","값을 선택해주세요")
                return
            }


        }

        /**
         * date format 은 일까지 있어야함
         */
        if (body.joinAt.equals("YYYY.MM") ||body.joinAt.equals("재학중") ){
            body.joinAt = ""
        }else{
            body.joinAt = "${body!!.joinAt}-01"
        }
        if (body.quitAt.equals("YYYY.MM") ||body.quitAt.equals("재학중") ){
            body.quitAt = ""
        }else{
            body.quitAt = "${body!!.quitAt}-01"
        }
            compositeDisposable.add(
                resumeRepo.patchMilitaryUpdate(token, body)
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