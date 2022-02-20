package com.team.ozet.views.main_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.announcement.AnnouncementResultModel
import com.team.ozet.data.announcement.remote.AnnouncementRepository
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timerTask

class MainFragmentViewModel(private val announcementRepo: AnnouncementRepository) : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()
    private val _string = SingleLiveEvent<String>()
    private val _noticeList = MutableLiveData<List<String>>()
    private val _themeChange = SingleLiveEvent<Unit>()
    private val _goLogin = SingleLiveEvent<Unit>()
    private val _goZet = SingleLiveEvent<Unit>()
    private val _goJoin = SingleLiveEvent<Unit>()
    private val _announcementResult = MutableLiveData<AnnouncementResultModel>();

    val clickEvent : LiveData<Unit> get() = _clickEvent
    val string: LiveData<String> get() = _string
    val noticeList: LiveData<List<String>> get() = _noticeList
    val themeChange: LiveData<Unit> get() = _themeChange
    val goLogin : LiveData<Unit> get() = _goLogin
    val goZet : LiveData<Unit> get() = _goZet
    val goJoin : LiveData<Unit> get() = _goJoin
    val announcementResult:LiveData<AnnouncementResultModel> get() = _announcementResult;

    fun click(){
        _clickEvent.call()
    }
    fun setNoticeList(){
        var list = listOf<String>("hi","ho","aaa","bbb","ccc","ddd","fff","ggg","hhhh","iiii","jjj","kkk","lll","mmm","nnn","o3")
        _noticeList.value = list
    }

    fun themeChange(){
        _themeChange.call()
    }

    fun goLogin(){
        _goLogin.call()
    }

    fun goZet(){
        _goZet.call()
    }

    fun goJoin(){
        _goJoin.call()
    }




    fun getAnnouncement(offset: Int, limit: Int,token: String){
        compositeDisposable.add(
            announcementRepo.getBookmarks(offset,limit,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        if (it.results == null){
                            _announcementResult.value = it.results[0]
                        }
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }




}