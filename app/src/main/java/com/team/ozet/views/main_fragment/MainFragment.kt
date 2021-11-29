package com.team.ozet.views.main_fragment

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentMainBinding
import com.team.ozet.views.notice_list.NoticeListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {


    private val viewModel: MainFragmentViewModel by viewModel()

    private lateinit var noticeAdapter: NoticeAdapter

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        callback()

    }

    private fun callback() {
        with(viewModel){
            themeChange.observe(this@MainFragment, Observer {
                // dark mode test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                // white mde test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            })
            goLogin.observe(this@MainFragment, Observer {

            })
        }
    }

    private fun initAdapter() {
        viewModel.setNoticeList()

        noticeAdapter = NoticeAdapter(thisContext)

        binding.rvNotice.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL,false)
            adapter = noticeAdapter
            setRecyclerListener {
            }
        }

        binding.rvNotice2.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL,false)
            adapter = noticeAdapter
        }
        binding.rvNotice3.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL,false)
            adapter = noticeAdapter
        }
    }



}