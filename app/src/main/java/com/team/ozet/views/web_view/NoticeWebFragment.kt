package com.team.ozet.views.web_view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.gson.JsonObject
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentNoticeWebBinding
import com.team.ozet.utils.Test
import com.team.ozet.utils.Web
import com.team.ozet.views.notice_list.NoticeListViewModel
import com.team.ozet.views.zet.academic_bg.ZetAcademicBGFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoticeWebFragment : BaseFragment<FragmentNoticeWebBinding>(R.layout.fragment_notice_web) {
    private val viewModel: NoticeWebViewModel by viewModel()
    //event 0 = list , 1 = detail
    private val args: NoticeWebFragmentArgs by navArgs()
    var listUrl = "https://hybrid.ozet.app/#/list/"
    var detailUrl = "https://hybrid.ozet.app/#/recruitment/detail/"  //공고 아이디 추가해야함

//    /list/all 전체공고  all?_si=1
///list/recommend 추천공고
///list/book-marked 북마크
///filter/address 주소필터
///recruitment/detail/:id 상세공고

    override fun init() {

        urlInit()
        webViewChange()
        callback()
//        backPressed()
        // todo 나중에 상태바 설정 다시
        activity?.actionBar?.hide()

        binding.btn.setOnClickListener {

            binding.wv.loadUrl("javascript:window.setAccessToken(\"" + Test.testToken + "\")")
        }


    }

    private fun urlInit() {
        when(args.event){
            Web.WEB_DETAIL ->{
                detailUrl += args.3
                initWebView(detailUrl)
            }
            Web.WEB_LIST_ALL ->{
                listUrl+= "all?_si=1"
                initWebView(listUrl)
            }
            Web.WEB_LIST_BOOKMARK ->{
                listUrl+= "book-marked"
                initWebView(listUrl)
            }
            Web.WEB_LIST_RECOMMEND ->{
                listUrl+= "recommend"
                initWebView(listUrl)
            }
        }
    }

    // mobile
    private fun callback() {
        with(viewModel) {
            go.observe(this@NoticeWebFragment, Observer {
                Log.i("AAA", binding.etUrl.text.toString())
                binding.wv.loadUrl(binding.etUrl.text.toString())
            })
        }

    }


    private fun webViewChange() {
        binding.etUrl.setOnEditorActionListener { textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                binding.wv.loadUrl(textView.text.toString())
                handled = true
            }
            handled
        }

    }


    private fun initWebView(url: String) {

        binding.wv.apply {
            addJavascriptInterface(
                WebAppInterface(
                    thisContext,
                    findNavController(),
                    binding.wv
                ), "webviewBrdige"
            )
            setWebViewClient(WebViewClient())// 클릭시 새창 안뜨게
            settings.javaScriptEnabled = true// 웹페이지 자바스클비트 허용 여부
            isHorizontalScrollBarEnabled = false
            isVerticalScrollBarEnabled = false
            loadUrl(url)
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

//    private fun backPressed() {
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    binding.wv.loadUrl("javascript:window.backEvent()")
//                }
//
//            })
//    }

    class WebAppInterface(
        private val context: Context,
        nav: NavController,
        wv: WebView,
    ) {
        val navController = nav
        var webView = wv

        @JavascriptInterface
        fun token() {
            webView.loadUrl("javascript:window.setAccessToken(\"" + Test.testToken + "\")")
        }

        @JavascriptInterface
        fun apply( user: JsonObject) {
            // 이력서
//  const applyUser: {
//  name: string;
//  shopName: string;
//  announcementTitle: string;
//  resumeURL: string;
//  };

        }

        @JavascriptInterface
        fun login() {
            navController.navigate(R.id.action_mainFragment_to_joinFragment)
        }

        @JavascriptInterface
        fun closeWebView() {
            navController.popBackStack()
        }
    }

}