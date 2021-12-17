package com.team.ozet.views.main_fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timerTask

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {


    private val viewModel: MainFragmentViewModel by viewModel()

    private lateinit var noticeAdapter: NoticeAdapter
    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        callback()


    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


    private fun callback() {
        with(viewModel) {
            themeChange.observe(this@MainFragment, Observer {
                // dark mode test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                // white mde test
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            })
            goLogin.observe(this@MainFragment, Observer {
                findNavController().navigate(R.id.action_mainFragment_to_noticeListFragment)
            })

            goZet.observe(this@MainFragment, Observer {
                findNavController().navigate(R.id.action_mainFragment_to_joinFragment)
            })


        }
    }

    private fun initAdapter() {
        viewModel.setNoticeList()

        noticeAdapter = NoticeAdapter(thisContext)

        binding.rvNotice.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = noticeAdapter
            setRecyclerListener {
            }
        }

        binding.rvNotice2.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = noticeAdapter
        }
        binding.rvNotice3.apply {
            layoutManager = LinearLayoutManager(
                thisContext, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = noticeAdapter
        }
    }


}