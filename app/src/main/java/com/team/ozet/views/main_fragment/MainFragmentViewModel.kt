package com.team.ozet.views.main_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.announcement.AnnouncementList
import com.team.ozet.data.announcement.AnnouncementResponse
import com.team.ozet.data.announcement.remote.AnnouncementRepository
import com.team.ozet.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class MainFragmentViewModel(private val announcementRepo: AnnouncementRepository) : BaseViewModel() {
    private val _clickEvent = SingleLiveEvent<Unit>()
    private val _string = SingleLiveEvent<String>()
    private val _themeChange = SingleLiveEvent<Unit>()
    private val _noticeList = MutableLiveData<ArrayList<AnnouncementList>>()
    private val _announcementResult = MutableLiveData<AnnouncementResponse>()

    val clickEvent : LiveData<Unit> get() = _clickEvent
    val string: LiveData<String> get() = _string
    val noticeList: LiveData<ArrayList<AnnouncementList>> get() = _noticeList
    val themeChange: LiveData<Unit> get() = _themeChange

    val announcementResult:LiveData<AnnouncementResponse> get() = _announcementResult;

    fun click(){
        _clickEvent.call()
    }
    fun setNoticeList(){
//      _noticeList.value =   AnnouncementList();
    }

    fun themeChange(){
        _themeChange.call()
    }


    fun getAnnouncement(offset: Int, limit: Int){
        compositeDisposable.add(
            announcementRepo.getAnnouncement(offset,limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        if (it != null){
                            var value = ArrayList<AnnouncementList>()
                            value.add(AnnouncementList(it.results,"북마크"))

                            _noticeList.value = value
                        }
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }

    fun getTest(offset: Int, limit: Int){
        compositeDisposable.add(
            announcementRepo.getBookmarks(offset,limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        Log.i("AAA", it.toString())

                        if (it != null){

                        }
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }




}