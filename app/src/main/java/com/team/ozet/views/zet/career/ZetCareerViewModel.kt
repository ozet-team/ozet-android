package com.team.ozet.views.zet.career

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.CareerModel
import com.team.ozet.data.resume.remote.ResumeRepository
import com.team.ozet.utils.SingleLiveEvent
import com.team.ozet.utils.ZetEnum
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetCareerViewModel(private val resumeRepo:ResumeRepository) : BaseViewModel() {
    private val _clickPosition = SingleLiveEvent<Unit>()
    private val _clickDone = SingleLiveEvent<Unit>()
    private val _career = MutableLiveData<CareerModel>()

    val careerModel:LiveData<CareerModel> = _career
    val clickPosition :LiveData<Unit> get() = _clickPosition


    fun clickPosition(){
        _clickPosition.call()
    }

    fun setCareerData(data: CareerModel){
        //string 변환
        data.position = ZetEnum.CAREER.valueChange(data.position)

        _career.value = data
        isCreate(data.id == 0)
        if (data.id == 0){
            setSecondText("")
        }else{
            setSecondText("삭제")
        }
    }


    fun createCareer(token: String){
        var body = careerModel.value

        if (body != null) {

            /**
             * date format 은 일까지 있어야함
             */
            if (body.joinAt.equals("YYYY.MM") ||body.joinAt.equals("근무중") ){
                body.joinAt = ""
            }else{
                body.joinAt = "${body!!.joinAt}-01"
            }
            if (body.quitAt.equals("YYYY.MM") ||body.quitAt.equals("근무중") ){
                body.quitAt = ""
            }else{
                body.quitAt = "${body!!.quitAt}-01"
            }
            //string 변환
            body.position = ZetEnum.CAREER.valueChange(body.position)

            compositeDisposable.add(
                resumeRepo.postCareerAdd(token,  body)
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

    fun updateCareer(token: String) {
        var body = careerModel.value
        //string 변환
        if (body != null) {
            body.position = ZetEnum.MILITARY.valueChange(body.position)
        }
        if (body?.id != null) {
            compositeDisposable.add(
                resumeRepo.patchCareerUpdate(token, body.id, body)
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

    fun deleteCareer(token: String) {
        var id = careerModel.value?.id
        if (id != null) {
            compositeDisposable.add(
                resumeRepo.deleteCareer(token, id)
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

