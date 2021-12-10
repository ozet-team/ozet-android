package com.team.ozet.views.join

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentJoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.concurrent.timerTask

class JoinFragment : BaseFragment<FragmentJoinBinding>(R.layout.fragment_join) {

    private val viewModel: JoinViewModel by viewModel()
    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        callback()
        checkPhoneNumber()
    }

    private fun callback() {
        with(viewModel) {
            clickEvent.observe(this@JoinFragment, Observer {
                binding.llAuth.visibility = View.VISIBLE
                startAuthTime()
//                if (isValidCellPhoneNumber(binding.incluePhone.etBase.text.toString())) {
//                    //TODO 인증번호 조건 추가 시 if 조건 추가
//                    val bundle =
//                        bundleOf("userPhonNumber" to binding.incluePhone.etBase.text.toString())
//                    findNavController().navigate(
//                        R.id.action_joinFragment_to_infoInputFragment,
//                        bundle
//                    )
//                }
            })
        }
    }

    // timerTask onDestroy 일떄 캔슬 해줘야함   재시작 로직 없음
    private fun startAuthTime() {

        var totalTime = 180L // 3분

        timer.schedule(timerTask {
            activity?.runOnUiThread {
                this.run {
                    totalTime--

                    var minute = TimeUnit.SECONDS.toMinutes(totalTime) - TimeUnit.SECONDS.toHours(
                        totalTime
                    )
                    var second = TimeUnit.SECONDS.toSeconds(totalTime) - TimeUnit.SECONDS.toMinutes(
                        totalTime
                    ) * 60
                    // text 연결
                    Log.i("AAA", "run $minute 분 $second")
                    var strTime = "%02d".format(minute) + " : " + "%02d".format(second)
                    binding.tvTimer.text = strTime
                    // 0초일때 timer task 캔슬
                    if (totalTime == 0L) {
                        this.cancel()
                        Log.i("AAA", "cancel")
                    }
                }
            }
        }, 0, 1000)

    }

    private fun stopAuthTime() {
        timer.cancel()
        binding.tvTimer.text = "00:00"
    }

    fun checkPhoneNumber() {
        binding.incluePhone.etBase.addTextChangedListener {
            if (isValidCellPhoneNumber(binding.incluePhone.etBase.text.toString())) {
                binding.btnNext.setBackgroundColor(Color.parseColor("#5D2FFF"));
                binding.btnNext.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                binding.btnNext.setBackgroundColor(Color.parseColor("#F0F2F5"));
            }
        }
    }

    fun isValidCellPhoneNumber(cellphoneNumber: String): Boolean {
        //핸드폰번호 유효성
//        if (!Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", cellphoneNumber)) {
//            Toast.makeText(thisContext, "올바른 핸드폰 번호가 아닙니다.", Toast.LENGTH_SHORT).show()
//            return false
//        }
        var returnValue: Boolean = false
        var regex: String =
            "^\\s*(010|011|012|013|014|015|016|017|018|019)(-|\\)|\\s)*(\\d{3,4})(-|\\s)*(\\d{4})\\s*$"
        var pattern: Pattern = Pattern.compile(regex)
        var matcher: Matcher = pattern.matcher(cellphoneNumber)
        if (matcher.matches()) {
            returnValue = true
        }
        return returnValue
    }
}