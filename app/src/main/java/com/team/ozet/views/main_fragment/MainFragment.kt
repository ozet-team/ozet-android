package com.team.ozet.views.main_fragment

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentMainBinding
import com.team.ozet.utils.Test
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {


    private val viewModel: MainFragmentViewModel by viewModel()

    private lateinit var noticeAdapter: NoticeAdapter
    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        viewModelCallback()
        viewModel.getAnnouncement(0,20, Test.testToken)
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
            goLogin.observe(this@MainFragment, Observer {
                findNavController().navigate(R.id.action_mainFragment_to_zetMainFragment)
            })

            goZet.observe(this@MainFragment, Observer {
                findNavController().navigate(R.id.action_mainFragment_to_joinFragment)
            })


        }
    }

    private fun initAdapter() {
        viewModel.setNoticeList()

        noticeAdapter = NoticeAdapter(thisContext,itemClick = {
            findNavController().navigate(R.id.action_mainFragment_to_noticeListFragment)
        })

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