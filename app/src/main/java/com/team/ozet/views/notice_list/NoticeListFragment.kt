package com.team.ozet.views.notice_list

import android.content.Context
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
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebView.setWebContentsDebuggingEnabled
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentNoticeListBinding
import com.team.ozet.utils.Test
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(R.layout.fragment_notice_list) {

    private val viewModel: NoticeListViewModel by viewModel()

    val url = "https://hybrid.ozet.app/#/list/all?_si=1"
    var detailUrl = "https://hybrid.ozet.app/#/recruitment/detail/1"  //공고 아이디 추가해야함


    override fun init() {



        initWebView(detailUrl)
        webViewChange()
        callback()
//        backPressed()
        // todo 나중에 상태바 설정 다시
        activity?.actionBar?.hide()

        binding.btn.setOnClickListener {

            binding.wv.loadUrl("javascript:window.setAccessToken(\"" + Test.testToken + "\")")
        }


    }
    // mobile

    private fun callback() {
        with(viewModel) {
            go.observe(this@NoticeListFragment, Observer {
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
            setWebContentsDebuggingEnabled(true);
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
        fun apply( user:JsonObject) {
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