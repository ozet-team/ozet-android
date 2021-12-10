package com.team.ozet.views.notice_list

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebView.setWebContentsDebuggingEnabled
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentNoticeListBinding

class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(R.layout.fragment_notice_list) {

    val url = "https://hybrid.ozet.app/#/list/all?_si=1"

    override fun init() {

        initWebView(url)
    }



    private fun initWebView(url:String) {

        binding.wv.apply{
            setWebViewClient(WebViewClient())// 클릭시 새창 안뜨게
            settings.javaScriptEnabled = true// 웹페이지 자바스클비트 허용 여부
            isHorizontalScrollBarEnabled = false
            isVerticalScrollBarEnabled = false
            loadUrl(url)
            setWebContentsDebuggingEnabled(true);

        }
    }
}