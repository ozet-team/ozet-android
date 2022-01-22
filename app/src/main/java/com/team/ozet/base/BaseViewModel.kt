package com.team.ozet.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()
    private var _backClick = SingleLiveEvent<Unit>()
    private var _showToast = SingleLiveEvent<String>()
    private var _disableClick = SingleLiveEvent<Unit>()
    private val _secondText = MutableLiveData<String>()
    private val _isCreate = SingleLiveEvent<Boolean>()
    val backClick: LiveData<Unit> get() = _backClick
    val showToast: LiveData<String> get() = _showToast
    val disableClick: LiveData<Unit> get() = _disableClick
    val secondText:LiveData<String> get() = _secondText
    val isCreate:LiveData<Boolean> get() = _isCreate


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun isCreate(boolean: Boolean){
        _isCreate.value = boolean
    }

    fun onBackClick() {
        _backClick.call()
    }
    fun onShowToast(text: String) {
        _showToast.value = text
    }

    fun setSecondText(text:String){
        _secondText.value = text
    }

    fun disableClick(){
        _disableClick.call()
    }

}