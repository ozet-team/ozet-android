package com.team.ozet.views.join

import android.util.Log
import androidx.lifecycle.LiveData
import com.ljjy.projecta.data.login.source.LoginRepository
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.user_login.Test
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class JoinViewModel(private val repository: LoginRepository) : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()

    val clickEvent : LiveData<Unit> get() = _clickEvent

    fun click(){
        _clickEvent.call()
    }

    fun test(){
        val test = Test(user_id = "9")
        compositeDisposable.add(
            repository.postTest(test)
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