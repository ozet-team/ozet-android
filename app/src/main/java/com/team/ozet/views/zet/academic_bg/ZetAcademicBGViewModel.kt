package com.team.ozet.views.zet.academic_bg

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.AcademicModel
import com.team.ozet.data.resume.repository.ResumeRepository
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetAcademicBGViewModel(private val resumeRepo: ResumeRepository) : BaseViewModel() {

    private val _academic = MutableLiveData<AcademicModel>()


    val academicModel: LiveData<AcademicModel> = _academic

    fun setAcademicData(data: AcademicModel) {
        if (data.joinAt.equals("")) {
            data.joinAt = "YYYY.MM"
            setSecondText("")
        } else {
            setSecondText("삭제")
        }
        if (data.quitAt.equals("")) {
            data.quitAt = "YYYY.MM"
        }
        _academic.value = data
        isCreate(data.id == 0)
    }

    fun createAcademic(token: String){
        var body = academicModel.value

        if (body != null) {

            /**
             * date format 은 일까지 있어야함
             */
            if (body.joinAt.equals("YYYY.MM") ||body.joinAt.equals("재학중") ){
                body.joinAt = null
            }else{
                body.joinAt = "${body!!.joinAt}-01"
            }
            if (body.quitAt.equals("YYYY.MM") ||body.quitAt.equals("재학중") ){
                body.quitAt = null
            }else{
                body.quitAt = "${body!!.quitAt}-01"
            }

            compositeDisposable.add(
                resumeRepo.postAcademicAdd(token,  body)
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

    fun updateAcademic(token: String) {
        var body = academicModel.value
        if (body?.id != null) {
            compositeDisposable.add(
                resumeRepo.patchAcademicUpdate(token, body.id, body)
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

    fun deleteAcademic(token: String) {
        var id = academicModel.value?.id
        if (id != null) {
            compositeDisposable.add(
                resumeRepo.deleteAcademic(token, id)
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