package com.team.ozet.views.join

import android.util.Log
import androidx.lifecycle.LiveData
import com.ljjy.projecta.data.login.source.LoginRepository
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.pass_code.PassCode
import com.team.ozet.data.pass_code.PassCodeRepository
import com.team.ozet.data.pass_code.RequestedVerify
import com.team.ozet.data.pass_code.User
import com.team.ozet.data.user_login.Test
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.http.hasBody

class JoinViewModel(private val repository: PassCodeRepository) : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()
    private val _requestedVerify = SingleLiveEvent<PassCode>()

    val clickEvent: LiveData<Unit> get() = _clickEvent
    val requestedVerify: LiveData<PassCode> get() = _requestedVerify

    fun click() {
        _clickEvent.call()
    }

    fun postPassCodeRequest(phoneNumber: String) {
        val passCode = PassCode(phoneNumber = phoneNumber)
        compositeDisposable.add(
            repository.postPassCodeRequest(passCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        _requestedVerify.value = it
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }
    //TODO 희락오빠한테질문 : 서버 500
    fun postPassCode(phoneNumber: String, passCode: String) {
        val passCode = PassCode(phoneNumber, passCode)
        compositeDisposable.add(
            repository.postPassCode(passCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                    Log.i("AAA", "hi : ${it.toString()}")
                },
                    onError = {
                    Log.i("AAA", "err : ${it.toString()}")
                })
        )
    }
}