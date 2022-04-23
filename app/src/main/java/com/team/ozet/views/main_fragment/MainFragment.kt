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
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {


    private val viewModel: MainFragmentViewModel by viewModel()
    private var confirmDialog: CustomDialog? = null

    private lateinit var noticeListAdapter: NoticeInfoAdapter
    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        viewModelCallback()
        viewModel.setNoticeList()
//        viewModel.getTest(0,5)
        viewModel.getAnnouncement(0,5)
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


    private fun viewModelCallback() {
        with(viewModel) {
            themeChange.observe(this@MainFragment, Observer {
                // dark mode test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                // white mde test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            })
            noticeList.observe(this@MainFragment, Observer {
                var concatAdapter = ConcatAdapter(
                    NoticeAdapter(
                        loginClick = { findNavController().navigate(R.id.action_mainFragment_to_zetMainFragment)},
                        noticeClick = {findNavController().navigate(R.id.action_mainFragment_to_joinFragment)}
                    ),
                    NoticeListAdapter(
                        it,
                        NoticeListAdapter.ItemHandler { event ->
                            when(event){
                                NoticeEvent.NOTICE_CLICK ->{

                                }
                                NoticeEvent.DETAIL_CLICK ->{

                                }
                            }
                        }
                    )
                )

                binding.rv.adapter = concatAdapter

            })
            announcementResult.observe(this@MainFragment, Observer {

            })

        }
    }

    private fun initAdapter() {


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


