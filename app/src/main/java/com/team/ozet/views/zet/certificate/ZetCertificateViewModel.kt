package com.team.ozet.views.zet.certificate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.CertificateModel
import com.team.ozet.data.resume.repository.ResumeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetCertificateViewModel(private val resumeRepo: ResumeRepository) : BaseViewModel() {
    private val _certificate = MutableLiveData<CertificateModel>()

    val certificateModel: LiveData<CertificateModel> = _certificate

    fun setCertificateData(data: CertificateModel){
        _certificate.value = data
        isCreate(data.id == 0)
        if (data.id == 0){
            setSecondText("")
        }else{
            setSecondText("삭제")
        }
    }

    fun createCertificate(token: String){

        var body = certificateModel.value

        if (body != null) {
            /**
             * date format 은 일까지 있어야함
             */
            if (body.certificateAt.equals("YYYY.MM.DD")  ){
                body.certificateAt = "20-01-01"
            }

            compositeDisposable.add(
                resumeRepo.postCertificateAdd(token,  body)
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

    fun updateCertificate(token: String) {
        var body = certificateModel.value
        if (body?.id != null) {
            compositeDisposable.add(
                resumeRepo.patchCertificateUpdate(token, body.id, body)
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

    fun deleteCertificate(token: String) {
        var id = certificateModel.value?.id
        if (id != null) {
            compositeDisposable.add(
                resumeRepo.deleteCertificate(token, id)
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