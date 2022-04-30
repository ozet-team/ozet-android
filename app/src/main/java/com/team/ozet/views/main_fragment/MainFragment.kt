package com.team.ozet.views.main_fragment

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentMainBinding
import com.team.ozet.utils.Test
import com.team.ozet.utils.Web
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {


    private val viewModel: MainFragmentViewModel by viewModel()

    private lateinit var noticeListAdapter: NoticeListAdapter
    private lateinit var noticeAdapter: NoticeAdapter

    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        viewModelCallback()
        viewModel.setNoticeList(0, 5)

    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


    private fun viewModelCallback() {
        with(viewModel) {
            announcementAdd.observe(this@MainFragment, Observer {
                noticeListAdapter.noticeInfoNotify()
            })
            themeChange.observe(this@MainFragment, Observer {
                // dark mode test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                // white mde test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            })
            noticeList.observe(this@MainFragment, Observer {
                noticeListAdapter.addItems(it)
            })

        }
    }

    private fun initAdapter() {
        noticeListAdapter = NoticeListAdapter(
            NoticeListAdapter.ItemHandler { event, noticeId ->
                when (event) {
                    NoticeEvent.NOTICE_LIST_All_CLICK -> {

                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToNoticeWebFragment(
                            Web.WEB_LIST_ALL, noticeId))
                    }
                    NoticeEvent.NOTICE_LIST_BOOKMARK_CLICK -> {

                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToNoticeWebFragment(
                            Web.WEB_LIST_BOOKMARK, noticeId))
                    }
                    NoticeEvent.NOTICE_LIST_RECOMMEND_CLICK -> {

                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToNoticeWebFragment(
                            Web.WEB_LIST_RECOMMEND, noticeId))
                    }
                    NoticeEvent.DETAIL_CLICK -> {
                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToNoticeWebFragment(
                            Web.WEB_DETAIL,
                            noticeId))

                    }
                    NoticeEvent.BOOKMARK_CLICK -> {

                    }
                }
            }
        )

        noticeAdapter = NoticeAdapter(
            loginClick = { findNavController().navigate(R.id.action_mainFragment_to_zetMainFragment) },
            noticeClick = { findNavController().navigate(R.id.action_mainFragment_to_joinFragment) }
        )

        var concatAdapter = ConcatAdapter(
            noticeAdapter,
            noticeListAdapter
        )

        binding.rv.adapter = concatAdapter

    }

//    private fun showDialog(){
//        if(confirmDialog == null) {
//            confirmDialog = CustomDialog(40, "seasonTicket", "dataModel.ticket")
//            confirmDialog!!.setListener(object : CustomDialog.BtnClickListener {
//                override fun onPositiveClick() {
//                    //TODO
//                }
//
//                override fun onNegativeClick() {
//                //TODO
//                }
//            })
//        }
//        if(!confirmDialog?.isAdded!!) {
//            confirmDialog?.show((context as FragmentActivity).supportFragmentManager, "custoDialog")
//        }

}


