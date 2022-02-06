package com.team.ozet.views.zet.address

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.AcademicModel
import com.team.ozet.data.user.UserModel
import com.team.ozet.data.user.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ZetAddressViewModel(private val userRepo:UserRepository) : BaseViewModel() {
    private val _userModel = MutableLiveData<UserModel>()

    val userModel:LiveData<UserModel> get() = _userModel


    fun setUserModelData(data: UserModel) {
        _userModel.value = data
    }

    fun userUpdate(token: String){

        compositeDisposable.add(
            userRepo.patchUserUpdate(token,userModel.value!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onComplete = {
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