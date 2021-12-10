package com.team.ozet.views.notice_list

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebView.setWebContentsDebuggingEnabled
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentNoticeListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(R.layout.fragment_notice_list) {

    private val viewModel:NoticeListViewModel by viewModel()

    val url = "https://hybrid.ozet.app/#/list/all?_si=1"

    val naver = "https://www.naver.com"

    override fun init() {

        initWebView(url)
        webViewChange()
        callback()
        // todo 나중에 상태바 설정 다시
        activity?.actionBar?.hide()

    }

    private fun callback() {
            with(viewModel){
                go.observe(this@NoticeListFragment, Observer {
                    Log.i("AAA",binding.etUrl.text.toString())
                    binding.wv.loadUrl(binding.etUrl.text.toString())
                })
            }

    }


    private fun webViewChange(){
        binding.etUrl.setOnEditorActionListener{ textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                binding.wv.loadUrl(textView.text.toString())
                handled = true
            }
            handled
        }

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