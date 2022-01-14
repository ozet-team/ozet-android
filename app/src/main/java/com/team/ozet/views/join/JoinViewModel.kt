package com.team.ozet.views.join

import android.util.Log
import androidx.lifecycle.LiveData
import com.ljjy.projecta.data.login.source.LoginRepository
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.pass_code.PassCode
import com.team.ozet.data.pass_code.PassCodeRepository
import com.team.ozet.data.user_login.Test
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.http.hasBody

class JoinViewModel(private val repository: PassCodeRepository) : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()

    val clickEvent : LiveData<Unit> get() = _clickEvent

    fun click(){
        _clickEvent.call()
    }
    fun aa(){
        val passCode = PassCode(phoneNumber = "+821046587428")
        compositeDisposable.add(
            repository.postPassCodeRequest(passCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({success ->

                    Log.i("AAA","hi : ${success.toString()}")
                },{
                    Log.i("AAA", "err : ${it.toString()}")
                })
        )
    }
}