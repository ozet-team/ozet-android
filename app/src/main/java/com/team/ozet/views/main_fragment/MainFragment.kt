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
    private val timer =  Timer()

    override fun init() {
        binding.vm = viewModel
        initAdapter()
        callback()


    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    // timerTask onDestroy 일떄 캔슬 해줘야함   재시작 로직 없음
    private fun startAuthTime(){

        var totalTime = 180L // 3분

        timer.schedule( timerTask {
            activity?.runOnUiThread {
                this.run {
                    totalTime--
                    var minute = TimeUnit.SECONDS.toMinutes(totalTime) - TimeUnit.SECONDS.toHours(totalTime)
                    var second = TimeUnit.SECONDS.toSeconds(totalTime) - TimeUnit.SECONDS.toMinutes(totalTime) * 60
                    // text 연결
                    Log.i("AAA","run $minute 분 $second")
                    var strTime = "$minute 분 $second"
                    binding.tv.text = strTime
                    // 0초일때 timer task 캔슬
                    if (totalTime == 0L ){
                        this.cancel()
                        Log.i("AAA","cancel")
                    }
                }
            }
        },0,1000)

    }

    private fun stopAuthTime(){
        timer.cancel()
        binding.tv.text = "00:00"
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
                findNavController().navigate(R.id.action_mainFragment_to_noticeListFragment)
            })

            goZet.observe(this@MainFragment, Observer {
                findNavController().navigate(R.id.action_mainFragment_to_zetCareerFragment)
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