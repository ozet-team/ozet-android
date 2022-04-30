package com.team.ozet.views.main_fragment

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.announcement.AnnouncementList
import com.team.ozet.data.announcement.AnnouncementResponse
import com.team.ozet.data.announcement.remote.AnnouncementRepository
import com.team.ozet.utils.SingleLiveEvent
import com.team.ozet.utils.Web
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class MainFragmentViewModel(private val announcementRepo: AnnouncementRepository) :
    BaseViewModel() {
    private val _themeChange = SingleLiveEvent<Unit>()
    private val _noticeList = MutableLiveData<ArrayList<AnnouncementList>>()
    private val _announcementAdd = SingleLiveEvent<Unit>()

    val noticeList: LiveData<ArrayList<AnnouncementList>> get() = _noticeList
    val themeChange: LiveData<Unit> get() = _themeChange
    val announcementAdd: LiveData<Unit> get() = _announcementAdd


    fun themeChange() {
        _themeChange.call()
    }


    fun getAnnouncement(offset: Int, limit: Int) {
        compositeDisposable.add(
            announcementRepo.getAnnouncement(offset, limit,"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = { it ->
                        if (it != null) {
                            var list = _noticeList.value
                            list?.find { announcementList ->
                                _announcementAdd.call()
                                announcementList.name == "북마크"
                                announcementList.list.addAll(it.results)
                            }
                        }
                    },
                    onError = {
                        Log.e("Error", "$it")
                    }
                )
        )
    }

    fun setNoticeList(offset: Int, limit: Int) {
        var value = ArrayList<AnnouncementList>()
        compositeDisposable.add(
            announcementRepo.getAnnouncement(offset, limit,"")
                .flatMap { all ->
                    value.add(AnnouncementList(all.results, Web.WEB_ALL))
                    announcementRepo.getAnnouncement(offset, limit,"")
                        .subscribeOn(Schedulers.io())
                        .doOnError {
                            Log.i("AAA","모든 공고 error : $it")
                        }
                        .subscribeOn(Schedulers.io())

                }
                .flatMap { bookmark ->
                    value.add(AnnouncementList(bookmark.results, Web.WEB_BOOKMARK))
                    announcementRepo.getAnnouncement(offset, limit,"bookmark_count")
                        .subscribeOn(Schedulers.io())
                        .doOnError {
                            Log.i("AAA","북마크 error : $it")
                        }
                        .subscribeOn(Schedulers.io())

                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = { recommendation ->
                        value.add(AnnouncementList(recommendation.results, Web.WEB_RECOMMEND))
                        _noticeList.value = value
                    },
                    onError = {
                        Log.i("AAA","추천 공고 error : $it")
                    }
                )
        )
    }


}