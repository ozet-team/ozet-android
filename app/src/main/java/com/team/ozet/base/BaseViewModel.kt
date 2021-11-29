package com.team.ozet.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()
    private var _backClick = SingleLiveEvent<Unit>()
    private var _disableClick = SingleLiveEvent<Unit>()
    val backClick: LiveData<Unit> get() = _backClick
    val disableClick: LiveData<Unit> get() = _disableClick

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun onBackClick() {
        _backClick.call()
    }

    fun disableClick(){
        _disableClick.call()
    }

}